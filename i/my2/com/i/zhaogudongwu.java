package com.i;

class ren {
	// String type;
	String name;

	ren(String _name) {
		// this.type = _type;
		this.name = _name;
	}
}

interface zgdw {
	default void ws() {
	};

	default void htw() {
	};
}

class gr extends ren implements zgdw {
	gr(String _name) {
		super(_name);
		// TODO Auto-generated constructor stub
	}

	public void ws() {
		System.out.println("ιʳ1");
	};

	public void htw() {
		System.out.println("�����1");
	};

	void getName() {
		System.out.println(this.name);
	};

}

class nm extends ren implements zgdw {
	nm(String _name) {
		super(_name);
		// TODO Auto-generated constructor stub
	}

	public void ws() {
		System.out.println("ιʳ2");
	};

	public void htw() {
		System.out.println("�����2");
	};

	void getName() {
		System.out.println(this.name);
	};
}

class gjgb extends ren implements zgdw {
	gjgb(String _name) {
		super(_name);
		// TODO Auto-generated constructor stub
	}

	public void ws() {
		System.out.println("ιʳ3");
	};

	public void htw() {
		System.out.println("�����3");
	};

	void getName() {
		System.out.println(this.name);
	};
}

public class zhaogudongwu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gr robin = new gr("robin");
		robin.getName();
		robin.ws();
		robin.htw();
		gr lisa = new gr("lisa");
		lisa.getName();
		lisa.ws();
		lisa.htw();
		gr jhon = new gr("jhon");
		jhon.getName();
		jhon.ws();
		jhon.htw();
	}

}
