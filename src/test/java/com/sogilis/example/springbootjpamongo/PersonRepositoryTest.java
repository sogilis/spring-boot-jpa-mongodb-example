package com.sogilis.example.springbootjpamongo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void save_and_find() {
        System.out.println(personRepository.count());
        Person arthur = personRepository.save(new Person("Arthur"));
        Person personFound = personRepository.findOne(arthur.getId());
        assertThat(personFound.getName()).isEqualTo("Arthur");
    }

}
