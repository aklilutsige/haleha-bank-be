package com.haleha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@ComponentScans({
//        @ComponentScan("com.haleha.controller"),
//        @ComponentScan("com.haleha.config")
//})
//@EnableJpaRepositories("com.haleha.repository")
//@EntityScan("com.haleha.model")

@SpringBootApplication
//@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
//@EnableWebSecurity(debug = true)
public class HalehaBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(HalehaBankApplication.class, args);
    }

}
