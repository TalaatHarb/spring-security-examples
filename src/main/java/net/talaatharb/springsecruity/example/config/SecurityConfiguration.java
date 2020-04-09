package net.talaatharb.springsecruity.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final String API_PATH = "/api/**";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http // HTTP Security
				.cors().and() // CORS policy
				.csrf().disable() // CSRF disable
				.authorizeRequests() // Configuration for authorization of requests
				.antMatchers(HttpMethod.OPTIONS, API_PATH).permitAll() // API end points
				.antMatchers(HttpMethod.DELETE, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.GET, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.POST, API_PATH).authenticated() // API end points
				.antMatchers(HttpMethod.PUT, API_PATH).authenticated() // API end points
				.and().formLogin().permitAll().successHandler((request, response, authentication) -> {
					// Nothing
				});
	}
}
