package com.rcdata.robin;

//import com.i.ren;

abstract class ren {
	String name;

	ren(String _name) {
		this.name = _name;
	}

	public abstract void getXing();

	public void getName() {
		System.out.println(this.name);
	}
}

class xue extends ren {
	int age;

	public xue(String _name,int _age) {
		super(_name);
		this.age = _age;
	}

	public void getXing() {
		System.out.println(age);
	}
}

public class TestAccess {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ren robin = new xue("robin",18);
		robin.getName();
		robin.getXing();
	}

}