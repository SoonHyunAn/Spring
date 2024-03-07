package com.example.abbs.entity;

public class Likes {
	private int lid;
	private String uid;
	private int bid;
	private int value;

	public Likes(int lid, String uid, int bid, int value) {
		this.lid = lid;
		this.uid = uid;
		this.bid = bid;
		this.value = value;
	}

	public Likes() {
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Likes [lid=" + lid + ", uid=" + uid + ", bid=" + bid + ", value=" + value + "]";
	}

}