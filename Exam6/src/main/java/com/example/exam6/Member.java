package com.example.exam6;

public class Member {
	private int mid;
	private String name;
	private int age;
	private String country;

	public Member(int mid, String name, int age, String country) {
		this.mid = mid;
		this.name = name;
		this.age = age;
		this.country = country;
	}

	public Member() {
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
