package com.i;

import java.io.File;
//import org.apache.commons.net.ftp.FTPClient; 
public class File2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dummyFile=new File("C:\\Users\\Robin\\Desktop\\U1802.exe");
		boolean fileExists =dummyFile.exists();
		if(fileExists){
			System.out.println("文件存在");
		}else {
			System.out.println("文件不存在");
		}
	}

}
