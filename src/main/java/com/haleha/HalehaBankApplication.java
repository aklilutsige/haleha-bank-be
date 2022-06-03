package com.haleha.halehabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.haleha.controller"),
        @ComponentScan("com.haleha.config")
})
@EnableJpaRepositories("com.haleha.repository")
@EntityScan("com.haleha.model")
//@EnableWebSecurity(debug = true)
public class HalehaBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(HalehaBankApplication.class, args);
    }

}
