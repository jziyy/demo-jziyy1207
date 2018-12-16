package com.example.demojziyy1207.Controler;

import com.alibaba.fastjson.JSON;
import com.example.demojziyy1207.Beans.DocBean;
import com.example.demojziyy1207.Beans.RMesBean;
import com.example.demojziyy1207.Beans.Statistics;
import com.example.demojziyy1207.Dao.StatisticsDao;
import com.example.demojziyy1207.Util.SendInfo;
import com.example.demojziyy1207.Util.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/verify")
public class VerifyController {
    @Autowired
    private StatisticsDao statisticsDao;

    @RequestMapping(value = "/work")
    public void getInfo() throws IOException {
        List<String> list = new ArrayList<>();

        File file = new  File(System.getProperty("user.dir")+ File.separator+"temp");
        file.mkdir();
        File file1 =new File(file.getAbsolutePath() + "/" + "id.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        for (int i = 0; list.size() == 0 ; i++) {
            list = statisticsDao.getID(1 + 1000*i,i*1000 + 1000);
            String json = ToJson.toSendVerifyJson(list);
            String returnJson = SendInfo.sendVerifyInfo(json);
            RMesBean bean = JSON.parseObject(returnJson,RMesBean.class);
            List<DocBean> list1= bean.getDocs();
            DocBean docBean;

            for (int j = 0; j < list1.size(); j++) {
                docBean = list1.get(j);
                if (!docBean.getFound()){
                   bufferedWriter.write(docBean.get_id());
                   bufferedWriter.newLine();
                   bufferedWriter.flush();
                }
            }

        }
        bufferedWriter.close();


    }

}
