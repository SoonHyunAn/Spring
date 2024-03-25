package com.example.springSecurity.Entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// 롬복을 통해 entity 구성을 간단히 표시 가능함. 롬복 개꿀이네 개꿀
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor 	// 기본 생성자. 생성자를 정의하지 않으면 자바에서 자동 생성
					// 다른 생성자 생성시 삭제 -> 정의해줘야함
@Builder
public class Member {
	private int mid;
	private String name;
	private LocalDate regDate;
	private String email;

	

}
