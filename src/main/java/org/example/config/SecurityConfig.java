package org.example.config;


import lombok.AllArgsConstructor;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{

	private final UserService userService;


	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/index").permitAll()
						.anyRequest().authenticated()
				)
//				.formLogin()
//				.loginPage("/login").permitAll()
//				.loginProcessingUrl("/sing-in")
//				.defaultSuccessUrl("public-data")
//				.failureUrl("/login?error")
//				.and()
//				.logout()
//				.logoutSuccessUrl("/")
//				.and()
//				.exceptionHandling()
//				.accessDeniedPage("/acces-denied")
				.formLogin(login -> login
						.loginProcessingUrl("/login").permitAll())
				.logout(logout -> logout.logoutSuccessUrl("/logout"));
		return http.build();
	}


//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userService.userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	UserDetailsManager inMemoryUserDetailsManager() {
//		var user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
//		var user2 = User.withUsername("admin").password("{noop}password").roles("USER", "ADMIN").build();
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
}
