package com.sogilis.example.springbootjpamongo.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRepositoryTester {

    @Autowired
    private PersonRepository personRepository;

    public void save_and_find() {
        System.out.println(personRepository.count());
        Person arthur = personRepository.save(new Person("Arthur"));
        Person personFound = personRepository.findOne(arthur.getId());
        assertThat(personFound.getName()).isEqualTo("Arthur");
    }

}
