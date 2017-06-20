package com.sogilis.example.springbootjpamongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootJpaMongoApplication {

    @Autowired
    private PersonRepository personRepository;

    public static void main(final String[] args) {
        SpringApplication.run(SpringBootJpaMongoApplication.class, args);
    }

    @Bean
    @Profile("verify")
    public CommandLineRunner onApplicationStart() {
        return args -> {
            System.out.println("--------------------------------------------");
            personRepository.save(new Person("Perceval"));
            personRepository.save(new Person("Karadoc"));

            System.out.println("People found:");
            personRepository.findAll().forEach(person -> System.out.println(person.getName()));
            System.out.println("--------------------------------------------");
        };
    }
}
