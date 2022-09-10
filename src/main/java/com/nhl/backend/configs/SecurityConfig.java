package com.nhl.backend.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl userDetailsService; 
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
     http.csrf().disable().cors().and().authorizeRequests()
      .antMatchers(HttpMethod.POST, "/login").permitAll()
      	.antMatchers(HttpMethod.GET, "/api/**").permitAll()
      	.antMatchers(HttpMethod.POST, "/api/**").permitAll()
      	.antMatchers(HttpMethod.DELETE, "/api/**").permitAll()
      	.antMatchers(HttpMethod.PUT, "/api/**").permitAll()
      // TÄMÄ PITÄÄ MUOKATA LOPUKSI NIIN ETTEI KÄYTTÄJIÄ (USERS TAI MAKERS) PÄÄSE HAKEMAAN
      //.antMatchers(HttpMethod.GET, "/api", "/api/**").permitAll()
      	//.antMatchers(HttpMethod.GET, "/api/tournaments", "api/tournaments/**").permitAll()
      //.antMatchers(HttpMethod.GET, "/api/makers", "/api/makers/**").permitAll()
          .anyRequest().authenticated()
          .and()
          // Filter for the api/login requests
          .addFilterBefore(new LoginFilter("/login",
           authenticationManager()),
                  UsernamePasswordAuthenticationFilter.class)
          // Filter for other requests to check JWT in header
          .addFilterBefore(new AuthenticationFilter(),
                  UsernamePasswordAuthenticationFilter.class);
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(userDetailsService)
	  .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = 
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //config.setAllowedOrigins(Arrays.asList("https://kyselyfrontend.herokuapp.com", "http://localhost:3000/", "http://kyselyfrontend.herokuapp.com", "http://kyselyfrontend.herokuapp.com/**"));
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        //config.setAllowCredentials(true);
        config.applyPermitDefaultValues();
        
        source.registerCorsConfiguration("/**", config);
        return source;
  }
}
