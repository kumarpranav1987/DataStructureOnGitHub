package com.pranav.datastructure.linkedlist.generic;

public class Emp implements Comparable<Emp>{
	private String name;
	private int age;
	public Emp(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Emp o) {
		return age - o.getAge();
	}
	
}
