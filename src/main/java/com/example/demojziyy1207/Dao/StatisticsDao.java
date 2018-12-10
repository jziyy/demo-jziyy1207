package com.example.demojziyy1207.Dao;

import com.example.demojziyy1207.Beans.AppMesg;
import com.example.demojziyy1207.Beans.ConnectBean;
import com.example.demojziyy1207.Beans.Statistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StatisticsDao {

    @Select("SELECT * FROM api_gateway_statistics_history LIMIT #{start},1000")
    public abstract List<Statistics> getData(@Param("start") Integer start);

    @Select("SELECT\n" +
            "\tid,appchname \n" +
            "FROM\n" +
            "\tapi_gateway_appmesg")
    public abstract List<AppMesg> getAllAppMesg();

    @Select("SELECT\n" +
            "\tconid,\n" +
            "\tNAME,\n" +
            "\turl,\n" +
            "\tpath \n" +
            "FROM\n" +
            "\tapi_gateway_connect")
    public abstract List<ConnectBean> getAllConName();


}
