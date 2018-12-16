package com.example.demojziyy1207;

import com.example.demojziyy1207.Dao.StatisticsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJziyy1207ApplicationTests {

    @Autowired
    private StatisticsDao statisticsDao;


    @Test
    public void text(){
        List<String> list =statisticsDao.getID(1,999);
        System.out.println(list);
    }
}
