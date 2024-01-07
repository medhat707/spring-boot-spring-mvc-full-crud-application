

package com.luv2code.springboot.thymeleafdemo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.luv2code.springboot.thymeleafdemo.service.MembersService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {


	private MembersService membersService;
	
	
	@Autowired
	public DemoSecurityConfig(MembersService theMembersService ) {
		membersService = theMembersService;
		
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(membersService);
		//daoProvider.setPasswordEncoder(passwordEncoder());
		return daoProvider;
	}
	
	
    @Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(authProvider());
	}
	
	
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
		configurer

				.requestMatchers("/register").permitAll()
				.requestMatchers("/employees/save").permitAll()
				.requestMatchers("/TheSystems").permitAll()
				.requestMatchers("/employees/showFormForUpdate").hasRole("ADMIN")
				.requestMatchers("/employees/delete").hasRole("ADMIN")


			//	.requestMatchers("/systems/**").hasRole("EMPLOYEE")
				.anyRequest().authenticated() 
				//means any request should be authenticated
				)
		.formLogin(form ->
		form
				.loginPage("/login")
				//.loginProcessingUrl("/")
				.permitAll() //allow everyone to access login page
				)
		.logout(logout -> logout.permitAll())  
		.exceptionHandling(configurer ->
		configurer.accessDeniedPage("/access-denied"));

			
							
		return http.build();
	}
	

}

