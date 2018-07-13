package vn.com.datasection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user@gmail.com").password("password").roles("USER").and().withUser("admin")
				.password("password").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login", "/home")
		.permitAll().antMatchers("/user/**")
				.hasAnyRole("USER").and().formLogin().loginPage("/login")
				.loginProcessingUrl("/home").defaultSuccessUrl("/home", true).failureUrl("/login?error").and().logout()
				.logoutSuccessUrl("/login?logout").permitAll().and().csrf().disable();
	}
}
