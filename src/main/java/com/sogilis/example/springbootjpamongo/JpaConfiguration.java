package com.sogilis.example.springbootjpamongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.sogilis.example.springbootjpamongo")
@Profile("jpa")
public class JpaConfiguration {
}
