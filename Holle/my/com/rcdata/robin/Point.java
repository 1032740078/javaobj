package com.rcdata.robin;

class person {
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class Student extends person {
	private String school;

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSchool(String school) {

		return school;
	}
}

public class Point {
	public static void main(String[] args) {
		Student robin = new Student();
		robin.setName("robin..liang");
		System.out.println(robin.getName());
		robin.setAge(22);
		System.out.println(robin.getAge());
		
	}
}
