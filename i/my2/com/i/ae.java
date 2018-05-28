package com.i;

public class ae {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,2,3};
		
		try{
		System.out.println(a[3]);
		}
		catch(ArrayIndexOutOfBoundsException ae){
			
			System.out.println("出错!数组下标越界!报错信息:");
			ae.printStackTrace();
		}
	}

}
