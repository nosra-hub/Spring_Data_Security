package tn.enig.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	javax.sql.DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		PasswordEncoder crypt = cryptageMP();
		try {

			auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery("select username as principal, password as credentials, 1 from user where username=? ")
			 .authoritiesByUsernameQuery("select User_username as principal, roles_role as role from user_role where User_username=?").passwordEncoder(crypt).rolePrefix("ROLE_");

			// auth.inMemoryAuthentication().withUser("amani").password(crypt.encode("enig")).roles("USER","ADMIN");
			// auth.inMemoryAuthentication().withUser("ali").password(crypt.encode("enig")).roles("USER");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void configure(HttpSecurity http) {
		try {
			

			
			  http.formLogin();
			  http.authorizeRequests().antMatchers("/add**","/delete***").hasRole("ADMIN");
			  http.authorizeRequests().anyRequest().authenticated(); 
			 http.logout(); 
			  http.csrf();
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

@Bean
public PasswordEncoder cryptageMP() {
	 return new BCryptPasswordEncoder();
}
}
