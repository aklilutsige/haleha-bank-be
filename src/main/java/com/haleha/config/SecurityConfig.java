package com.haleha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * /account - Secured
     * /balance - Secured
     * /loans - Secured
     * /cards - Secured
     * /notices - Not Secured
     * contact - Not Secured
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * custom configuration as per our requirement
         */
        http.cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200/"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);

                        return config;
                    }
                }).and()
                .authorizeHttpRequests()
                .antMatchers("/myAccount").authenticated()
                .antMatchers("/myBalance").authenticated()
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myCards").authenticated()
                .antMatchers("/user").permitAll()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and().formLogin()
                .and().httpBasic();
    }
//        @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//       auth.inMemoryAuthentication()
//               .withUser("admin").password("12345").authorities("admin").and()
//               .withUser("user").password("12345").authorities("read").and()
//               .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("admin").password("12345").authorities("admin").build();
//        UserDetails user1 = User.withUsername("user").password("12345").authorities("read").build();
//        userDetailsService.createUser(user);
//        userDetailsService.createUser(user1);
//        auth.userDetailsService(userDetailsService);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
