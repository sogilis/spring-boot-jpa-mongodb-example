package com.sogilis.example.springbootjpamongo.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sogilis.example.springbootjpamongo.domain.PersonRepositoryTester;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("jpa")
public class personRepositoryJpaTest {

    @Autowired
    private PersonRepositoryTester personRepositoryTester;

    @Test
    public void save_and_find() {
        personRepositoryTester.save_and_find();
    }
}
