package com.example.demojziyy1207.Controler;

import com.example.demojziyy1207.Dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/verify")
public class VerifyController {
    @Autowired
    private StatisticsDao statisticsDao;

    @RequestMapping(value = "/work")
    public void getInfo(){
        List<String> list =statisticsDao.getID(1,999);


    }

}
