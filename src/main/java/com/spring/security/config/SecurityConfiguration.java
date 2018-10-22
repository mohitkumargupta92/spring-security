package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("mohit").password("1234").roles("USER").and().withUser("admin")
				.password("1234").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				// .antMatchers("/rest/hello").access("hasRole('USER')")
				// .antMatchers("/rest/bye").access("hasRole('ADMIN')")
				.anyRequest().permitAll().and().addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
				.httpBasic();
		// .anyRequest().fullyAuthenticated().and().httpBasic();
		httpSecurity.csrf().disable();
	}

	@Bean
	public CustomFilter customFilter() {
		return new CustomFilter();
	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
