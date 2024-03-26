package com.example.springSecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.springSecurity.Service.MyOAuth2UserService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired private MyOAuth2UserService myOAuth2UserService;

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf(auth -> auth.disable()) // 괄호 안에는 람다함수를 사용해야 함.
			.headers(x -> x.frameOptions(y -> y.disable())) // CK Editor Image Upload 시 필요
			.authorizeHttpRequests(auth -> auth
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/user/register", "/user/list", 
							"/img/**","/css/**", "/js/**", "/error/**").permitAll() // ** : 모든 파일 엑세스
					.requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // 관리자 전용 경로 지정
					.anyRequest().authenticated())
			.formLogin(auth -> auth
				.loginPage("/user/login") 	// login form - requestMatchers에서 지정하지 않아도 괜찮음
				.loginProcessingUrl("/user/login") 
				// spring security 가 낚아챔. UserDetailService 구현객체에서 처리해주어야 함.
				.usernameParameter("uid").passwordParameter("pwd") 
				// Spring Security 에 name/password 의 변수 이름을 무엇을 할건지 말해주는 부분	
				.defaultSuccessUrl("/user/loginSuccess", true) 	
				// 내가 로그인 후 해야할 일 진행 Ex- session setting, 오늘의 명언 등
				.permitAll()
					)
			.oauth2Login(auth -> auth
					.loginPage("/user/login")
					// 소셜 로그인이 완료된 이후의 후처리
					// 1. 코드받기 (인증) 2. 엑세스 토큰(권한) 3. 사용자 프로필 정보 가져오기
					// 4. 3에서 받은 정보를 토대로 DB에 없으면 가입을 시켜줌
					// 5. 프로바이더가 제공하는 정보 + 추가정보 수집 (주소 등) - 네이버 카카오는 프로바이더도 지정해야 함
					.userInfoEndpoint(user->user.userService(myOAuth2UserService))
					.defaultSuccessUrl("/user/loginSuccess", true)
					.permitAll()
					)
			.logout(auth -> auth
					.logoutUrl("/user/logout")
					.invalidateHttpSession(true) // 로그아웃시 세션 초기화
					.deleteCookies("JSESSIONID") // 로그아웃시 쿠키 삭제
					.logoutSuccessUrl("/user/login")
					);
		
			return http.build();
	}
}
