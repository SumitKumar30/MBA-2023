package org.ncu.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
//		PasswordEncoder passwordEncoder = passwordEncoder();
		
		UserDetails john = User.builder()
				.username("John")
//				.password(passwordEncoder.encode("test123"))
				.password("{noop}test123")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mark = User.builder()
				.username("Mark")
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		
		UserDetails henry = User.builder()
				.username("Henry")
//				.password(passwordEncoder.encode("test123"))
				.password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(john, mark, henry);
		
	}
	
	
	
//	  @Bean public PasswordEncoder passwordEncoder() { return new
//	  BCryptPasswordEncoder(); }
//	 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests( configurer -> 
			{
				try {
					configurer
//			.requestMatchers(new RegexRequestMatcher("api/users/addUser", "POST")).hasRole("MANAGER")
							
							  .antMatchers(HttpMethod.POST, "/api/users/add**").hasRole("MANAGER")
							  .antMatchers(HttpMethod.GET, "/api/users/**").hasRole("ADMIN")
							  .anyRequest().authenticated()
							  .and()
							  .csrf()
							  .disable();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		);
		
		//use basic http authentication
		httpSecurity.httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();
		
	}
}
