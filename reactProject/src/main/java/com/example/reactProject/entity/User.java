package com.example.reactProject.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class User {
	private String uid;
	private String pwd;
	private String uname;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	private String picture;
	private String provider;
	private String role;
}
