package com.example.abbs.entity;

import java.time.LocalDate;

public class Users {
	private String uid;
	private String pwd;
	private String unmae;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private String profile;
	private String github;
	private String insta;
	private String location;

	public Users(String uid, String pwd, String unmae, String email, LocalDate regDate, int isDeleted, String profile,
			String github, String insta, String location) {
		this.uid = uid;
		this.pwd = pwd;
		this.unmae = unmae;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
		this.profile = profile;
		this.github = github;
		this.insta = insta;
		this.location = location;
	}

	public Users() {
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", pwd=" + pwd + ", unmae=" + unmae + ", email=" + email + ", regDate=" + regDate
				+ ", isDeleted=" + isDeleted + ", profile=" + profile + ", github=" + github + ", insta=" + insta
				+ ", location=" + location + "]";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUnmae() {
		return unmae;
	}

	public void setUnmae(String unmae) {
		this.unmae = unmae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getInsta() {
		return insta;
	}

	public void setInsta(String insta) {
		this.insta = insta;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
