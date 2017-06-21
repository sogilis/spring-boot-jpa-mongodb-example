package com.sogilis.example.springbootjpamongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.sogilis.example.springbootjpamongo")
@Profile("mongodb")
public class MongoConfiguration {
}
