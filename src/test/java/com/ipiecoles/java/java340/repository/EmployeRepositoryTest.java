package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.repository.EmployeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeRepositoryTest {

    @Autowired
    EmployeRepository employeRepository;

    @Test
    public  void testFindByNomOrPrenomAllIgnoreCase() {

    }

}