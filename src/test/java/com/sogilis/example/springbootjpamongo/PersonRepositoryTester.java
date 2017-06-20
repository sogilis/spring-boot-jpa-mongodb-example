package com.sogilis.example.springbootjpamongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.*;

@Component
public class PersonRepositoryTester {

    @Autowired
    private PersonRepository personRepository;

    public void save_and_find() {
        System.out.println(personRepository.count());
        final Person arthur = personRepository.save(new Person("Arthur"));
        final Person personFound = personRepository.findOne(arthur.getId());
        assertThat(personFound.getName()).isEqualTo("Arthur");
    }

}
