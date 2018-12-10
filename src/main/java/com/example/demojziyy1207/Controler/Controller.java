package com.example.demojziyy1207.Controler;

import com.example.demojziyy1207.Beans.AppMesg;
import com.example.demojziyy1207.Beans.ConnectBean;
import com.example.demojziyy1207.Beans.Statistics;
import com.example.demojziyy1207.Dao.StatisticsDao;
import com.example.demojziyy1207.Util.SendInfo;
import com.example.demojziyy1207.Util.ToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping(value = "/aaa")
public class Controller {

    @Autowired
    private StatisticsDao statisticsDao;
    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String insert(){

        long first = new Date().getTime();

        List<ConnectBean> connectBeans = statisticsDao.getAllConName();
        List<AppMesg> appMesgs = statisticsDao.getAllAppMesg();

        List<Statistics> list = null;//statisticsDao.getData(0);
        for (int i = 0; i<1000000000; i++) {
            list = statisticsDao.getData(1000 * i);
            if(list.size() == 0) {
                break;
            }
            System.out.println("------di " + i + "zu 1000 tiao");
            String startTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            long date1 = new Date().getTime();
            System.out.println("start" + startTime);

            String json = ToJson.doEsJson(list,connectBeans,appMesgs);

            SendInfo.sendInfo(json);
            long date2 = new Date().getTime();
            String endTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("end" + endTime);
            System.out.println("once time" + (date2-date1));


        }
        long last = new Date().getTime();
        System.out.println("all time" + (last - first));
        return "jziyy";

}
}
