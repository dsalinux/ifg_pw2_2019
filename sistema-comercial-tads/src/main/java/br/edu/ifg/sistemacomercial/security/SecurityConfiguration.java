/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author danilo
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login.xhtml").permitAll()
                        .antMatchers("/javax.faces.resource/**").permitAll()
                        .antMatchers("/**").authenticated().anyRequest()                        
                        .authenticated().and().formLogin().loginPage("/login.xhtml").and().csrf().disable();
	}

	@Autowired
	private UserDetailsService users;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(users).passwordEncoder(
				new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

}