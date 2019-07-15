package com.wcd.repository;

import com.wcd.CustermApplication;
import com.wcd.entity.MoviceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustermApplication.class)
public class MoviceTypeRepositoryTest {

    @Autowired
    MoviceTypeRepository moviceTypeRepository;
    @Test
    public void getMoviceTypesByUrlLike() {
        List<MoviceType> list = moviceTypeRepository.getMoviceTypesByUrlLike("bilbil/%");
        for (MoviceType m :
                list) {
            System.out.println(m);
        }
    }
}