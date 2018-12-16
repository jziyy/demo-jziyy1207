package com.example.demojziyy1207.Controler;

import com.example.demojziyy1207.Beans.Statistics;
import com.example.demojziyy1207.Dao.StatisticsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/aaa")
public class Controller {

    @Autowired
    private StatisticsDao statisticsDao;
//    @ResponseBody
//    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    public String insert(){
//
//        long first = new Date().getTime();
//
//        List<ConnectBean> connectBeans = statisticsDao.getAllConName();
//        List<AppMesg> appMesgs = statisticsDao.getAllAppMesg();
//
//        List<Statistics> list = null;
//        for (int i = 950; i<1000000000; i++) {
//            System.out.println("--------------------------------------");
//            Date startdate =new Date();
//
//            System.out.println("The program start time =" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startdate));
//
//            //查询开始时间
//            long searchStart = new Date().getTime();
//
//            //------------------
//            int i2 =9 ;
//
//
//
//
//
//            int i1 = i2*1000  ;
//            //mysql查询出的数据
//           list = statisticsDao.getData((10000 * i + i1),(10000 * i + i1+1000));
//           // list = statisticsDao. getDatafirst((1000 * i));
//
//            //查询结束时间
//            long searchEnd = new Date().getTime();
//            //查询时间
//            System.out.println("-Search Time = " + (searchEnd - searchStart));
//
//
//
//            if(list.size() == 0) {
//                break;
//            }
//            String startTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//
//            //插入开始时间
//            long date1 = new Date().getTime();
//
//            System.out.println("Start  insert time" +startTime);
//
//
//
//
//            String json = ToJson.doEsJson(list,connectBeans,appMesgs);
//
//            SendInfo.sendInfo(json);
//            long date2 = new Date().getTime();
//            String endTime  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//            System.out.println("once end" + endTime);
//
//            //插入所用时间
//            System.out.println("insert time " + (date2 - date1));
//
//
//            System.out.println("-The " + i + "th group(1" + i2 +"000-1"+ (i2 + 1) +"000)" + "once time" + (date2-startdate.getTime()));
//
//
//
//
//
//        }
//        long last = new Date().getTime();
//        System.out.println("all time" + (last - first));
//        return "jziyy";
//
//}



    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String insert(){

        for (int i = 0; i < 1000000000; i++) {

          List<Statistics> statisticsList = statisticsDao.getErrormsg(i*1000);

          if (statisticsList.size()==0){
              break;
          }


        }



        return "jziyy";
    }

}
