package br.com.odaguiri.codinginterview.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Entry points
        http.authorizeRequests()                
                .antMatchers("/problems/**").permitAll()
                // Disallow everything else..
                .anyRequest().authenticated();

        // Disable CSRF (cross site request forgery)
        http.csrf().disable();
	}

}
