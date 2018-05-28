package com.robin;

import com.robin.Ftp;
import com.robin.goFtp;

public class FtpLoginEnumeration {
	/*
	 * host:119.28.50.82 port:21 password:xxxxxxx user:1032740078_2
	 */
	public static void main(String[] args) throws Exception {
		Ftp user1 = new goFtp(21, "47.52.56.87", "xxxxxx", 1032740070);
		user1.goLogin();
	}

}
