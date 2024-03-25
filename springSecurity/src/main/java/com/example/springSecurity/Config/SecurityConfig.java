package com.example.springSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.csrf(auth -> auth.disable()) // 괄호 안에는 람다함수를 사용해야 함.
			.headers(x -> x.frameOptions(y -> y.disable())) // CK Editor Image Upload 시 필요
			.authorizeHttpRequests(auth -> auth
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/user/login", "/user/register", 
							"/img/**","/css/**", "/js/**", "/error/**").permitAll() // ** : 모든 파일 엑세스
					.requestMatchers("/admin/**").hasAuthority("ADMIN")
					.anyRequest().authenticated())
			.formLogin(auth -> auth
				.loginPage("/user/login") 	// login form
				.loginProcessingUrl("/user/login") 
				// spring security 가 낚아챔. UserDetailService 구현객체에서 처리해주어야 함.
				.usernameParameter("uid").passwordParameter("pwd") 
				// Spring Security에 name/password의 변수 이름을 무엇을 할건지 말해주는 부분	
				.defaultSuccessUrl("/user/loginSuccess", true) 	
				// 내가 로그인 후 해야할 일 진행 Ex) session setting, 오늘의 명언 등
				.permitAll()
					);
		
			return http.build();
	}
}
