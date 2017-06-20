package com.sogilis.example.springbootjpamongo.mongo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.sogilis.example.springbootjpamongo.domain")
@EnableMongoAuditing
@Profile("mongodb")
public class MongoConfiguration {
}
