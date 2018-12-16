package com.example.demojziyy1207.Util;


import com.alibaba.fastjson.JSON;
import com.example.demojziyy1207.Beans.AppMesg;
import com.example.demojziyy1207.Beans.ConnectBean;
import com.example.demojziyy1207.Beans.Statistics;

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


    public static String toSendVerifyJson(List<String> list){
       String json ="{\n" +
               "            \"docs\" : [\n" +



               "    ]\n" +
               "        }";

       StringBuffer stringBuffer =new StringBuffer();
       stringBuffer.append("{\n" +
               "            \"docs\" : [\n");


        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(   "            {\n" +
                    "                \"_id\" : \""+ list.get(i) +"\",\n" +
                    "                    \"stored_fields\" : [\"id\"]\n" +
                    "            },\n");
            if (i==list.size() -1){
                stringBuffer.append(   "            {\n" +
                        "                \"_id\" : \""+ list.get(i) +"\",\n" +
                        "                    \"stored_fields\" : [\"id\"]\n" +
                        "            }\n");
            }
        }


       stringBuffer.append( "    ]\n" +
               "        }");

            return stringBuffer.toString();

    }
}
