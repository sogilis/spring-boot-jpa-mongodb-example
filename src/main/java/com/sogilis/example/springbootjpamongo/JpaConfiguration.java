package com.sogilis.example.springbootjpamongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("jpa")
// Custom JPA configuration here
// @EnableJpaRepositories("com.sogilis.example.springbootjpamongo")
// @EnableJpaAuditing
public class JpaConfiguration {
}
