package com.rest.empdata.security;

import static com.rest.empdata.security.ApplicationUserRole.ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.rest.empdata.repository.EmployeeRepository;

@Configuration
@Order(1)
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
private final PasswordEncoder passwordEncoder;
@Autowired
public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
	this.passwordEncoder=passwordEncoder;
}
@Autowired
EmployeeRepository repository;
@Override
protected void configure(HttpSecurity http) throws Exception {
http
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/","home","/user/*","loginUser","changePassword"
    		  ,"details2","/change","*.jpg","details2","/user","/images/*").permitAll()
      .antMatchers("/admin/*","/login","/logout","login","logout","/admin").hasRole(ADMIN.name())
      .anyRequest()
      .authenticated()
      .and()
      .formLogin()
      .defaultSuccessUrl("/admin",true)
      .and()
      .logout()
          .logoutUrl("/logout")
          .clearAuthentication(true)
          .invalidateHttpSession(true)
          .logoutSuccessUrl("/");
}
@Override
@Bean
protected UserDetailsService userDetailsService() {
	UserDetails admin = User.builder()
	             .username("admin")
	             .password(passwordEncoder.encode("password"))
	             .roles(ADMIN.name())
	             .build();
	return new InMemoryUserDetailsManager(admin);
	}
}
