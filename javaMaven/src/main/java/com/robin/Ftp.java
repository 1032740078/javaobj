package com.robin;

abstract class Ftp {
	// 端口
	int port;
	// ftp服务器ip地址
	String host;
	String password;
	int user;

	public Ftp(int _port, String _host, String _password, int _user) {
		this.port = _port;
		this.host = _host;
		this.password = _password;
		this.user = _user;

	}

	// 尝试登录Ftp服务器
	public abstract void goLogin() throws Exception;

	// 登录成功
	public abstract void loginWin() throws Exception;

	// 记录成功的记录
	public abstract void setRecord(String state);

	// 发送成功的记录
	public abstract void sendRecord() throws Exception;

}
