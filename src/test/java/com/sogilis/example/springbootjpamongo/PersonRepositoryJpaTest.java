package com.sogilis.example.springbootjpamongo;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
// or, to load only beans involved with JPA + PersonRepositoryTester
// @DataJpaTest(includeFilters = @ComponentScan.Filter(type =
// FilterType.ASSIGNABLE_TYPE, classes = PersonRepositoryTester.class))
@Transactional
@ActiveProfiles("jpa")
public class PersonRepositoryJpaTest {

    @Autowired
    private PersonRepositoryTester personRepositoryTester;

    @Autowired
    private EntityManager entityManager;

    @After
    public void flush() {
        // Mandatory to make sure all SQL queries are executed in database.
        // Otherwise, queries are potentially cached and @Transactional may clear cache
        // at the end of the test.
        entityManager.flush();
    }

    @Test
    public void save_and_find() {
        personRepositoryTester.save_and_find();
    }
}
