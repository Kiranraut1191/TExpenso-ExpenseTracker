package com.rk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
				.requestMatchers("/api/user/all", "/api/user/register", "/api/user/login", "/api/expense/**",
						"/api/balance/**")
				.permitAll() // allow without login
				.anyRequest().authenticated() // secure others
				.and().httpBasic(); // or .formLogin() for UI-based login

		return http.build();
	}
}
