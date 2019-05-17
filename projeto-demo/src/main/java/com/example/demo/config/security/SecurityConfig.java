package com.example.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import com.example.demo.config.filter.JwtAthenticationFilter;
import com.example.demo.config.filter.JwtAuthorizationFilter;
import com.example.demo.config.security.service.CustomUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final CustomUserDetailsService customUserDetailsService;

	@Autowired
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
			.configurationSource(Request -> new CorsConfiguration().applyPermitDefaultValues())
			.and().csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, 
						 "/",
						 "/*.html",
						 "/favicon.ico",
						 "/**/*.html",
						 "/**/*.css",
						 "/**/*.js").permitAll()
			.antMatchers("/api/auth/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new  JwtAthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), customUserDetailsService));
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
