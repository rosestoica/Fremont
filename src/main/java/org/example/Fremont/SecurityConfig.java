package org.example.Fremont;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers("/works","/login", "/p0", "/p1", "/p2", "/p4", "/p5", "/p6", "/p7").permitAll()  // Allow public access to /works and /html
						.anyRequest().authenticated()  // Require authentication for other requests
				)
//.formLogin().disable();  // Disable form login (optional, if you don't want a form login)
				.formLogin(form -> form
						.loginPage("/p2")
						.defaultSuccessUrl("/p7", true)
						.permitAll()
				);
		return http.build();
	}
}
