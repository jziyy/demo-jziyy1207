package com.example.demojziyy1207.Util;


import com.alibaba.fastjson.JSON;
import com.example.demojziyy1207.Beans.AppMesg;
import com.example.demojziyy1207.Beans.ConnectBean;
import com.example.demojziyy1207.Beans.Statistics;
import com.example.demojziyy1207.Dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToJson {


    public static String doEsJson(List<Statistics> list,List<ConnectBean> connectBeans,List<AppMesg> appMesgs){

        Map<String,String> conINMap = new HashMap<>();
        Map<String,String> conIUMap = new HashMap<>();
        Map<String,String> appINMap = new HashMap<>();
        Map<String,String> conIPMap = new HashMap<>();
        connectBeans.forEach(s -> { conIPMap.put(s.getConid(),s.getPath()); });
        connectBeans.forEach(s -> { conIUMap.put(s.getConid(),s.getUrl());  });
        connectBeans.forEach(s -> { conINMap.put(s.getConid(),s.getName());} );
        appMesgs.forEach(s ->{ appINMap.put(s.getId(),s.getAppchname());});


        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < list.size(); i++) {
            Statistics statistics = list.get(i);
            statistics.setAppchname(appINMap.get(statistics.getAppid()));
            statistics.setName(conINMap.get(statistics.getConid()));
            statistics.setUrl(conIUMap.get(statistics.getConid()));
            statistics.setPath(conIPMap.get(statistics.getConid()));


            stringBuffer.append("{\"index\":{\"_id\":" + "\"" + statistics.getId() + "\"}}\n");
            stringBuffer.append(JSON.toJSONString(statistics)+"\n");
        }
        return stringBuffer.toString();
    }
}
