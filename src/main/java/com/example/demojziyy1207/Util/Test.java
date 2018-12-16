package com.example.demojziyy1207.Util;

import com.alibaba.fastjson.JSON;
import com.example.demojziyy1207.Beans.Statistics;

public class Test {
    public static void main(String[] args) {
        Statistics statistics =new Statistics();
        statistics.setStarttime_long(35445354);
        System.out.println(JSON.toJSONString(statistics));
    }
}
