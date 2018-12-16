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

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.conid,\n" +
            "\ta.userid,\n" +
            "\ta.success,\n" +
            "\ta.channel,\n" +
            "\ta.starttime,\n" +
            "\ta.endtime,\n" +
            "\tDATE_FORMAT( starttime, \"%Y\" ) YEAR,\n" +
            "\tDATE_FORMAT( starttime, \"%m\" ) MONTH,\n" +
            "\tDATE_FORMAT( starttime, \"%e\" ) DAY,\n" +
            "\tDATE_FORMAT( starttime, \"%H\" ) HOUR,\n" +
            "\tUNIX_TIMESTAMP( starttime ) * 1000 starttime_long,\n" +
            "\tUNIX_TIMESTAMP( endtime ) * 1000 endtime_long,\n" +
            "\ta.arg,\n" +
            "\ta.rspmsg,\n" +
            "\ta.time,\n" +
            "\ta.phonemodel,\n" +
            "\ta.opersystem,\n" +
            "\ta.appid,\n" +
            "\ta.username,\n" +
            "\ta.clientip \n" +
            "FROM\n" +
            "\tapi_gateway_statistics_history AS a \n" +
            "WHERE\n" +
            "\tid BETWEEN ( SELECT id FROM att WHERE uid = #{start} ) \n" +
            "\tAND ( SELECT id FROM att WHERE uid = #{end} )")
    public abstract List<Statistics> getData(@Param("start") Integer start,@Param("end") Integer end);

    @Select("SELECT\n" +
            "\ta.id,\n" +
            "\ta.conid,\n" +
            "\ta.userid,\n" +
            "\ta.success,\n" +
            "\ta.channel,\n" +
            "\ta.starttime,\n" +
            "\ta.endtime,\n" +
            "\tDATE_FORMAT( starttime, \"%Y\" ) YEAR,\n" +
            "\tDATE_FORMAT( starttime, \"%m\" ) MONTH,\n" +
            "\tDATE_FORMAT( starttime, \"%e\" ) DAY,\n" +
            "\tDATE_FORMAT( starttime, \"%H\" ) HOUR,\n" +
            "\tUNIX_TIMESTAMP( starttime ) * 1000 starttime_long,\n" +
            "\tUNIX_TIMESTAMP( endtime ) * 1000 endtime_long,\n" +
            "\ta.arg,\n" +
            "\ta.rspmsg,\n" +
            "\ta.time,\n" +
            "\ta.phonemodel,\n" +
            "\ta.opersystem,\n" +
            "\ta.appid,\n" +
            "\ta.username,\n" +
            "\ta.clientip \n" +
            "FROM\n" +
            "\tapi_gateway_statistics_history  a LIMIT #{start},1000")
    public abstract List<Statistics> getDatafirst(@Param("start") Integer start);

    @Select("SELECT\n" +
            "\tid,\n" +
            "\tsuccess \n" +
            "FROM\n" +
            "\tapi_gateway_statistics_history \n" +
            "\tLIMIT #{start},1000")
    public abstract List<Statistics> getSuccess(@Param("start") Integer start);

    @Select("SELECT\n" +
            "\tid,\n" +
            "\terrormsg \n" +
            "FROM\n" +
            "\tapi_gateway_statistics_history \n" +
            "\tLIMIT #{start},1000")
    public abstract List<Statistics> getErrormsg(@Param("start") Integer start);


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

    @Select("SELECT\n" +
            "\tid \n" +
            "FROM\n" +
            "\tatt WHERE uid\n" +
            "\tBETWEEN #{start} AND #{end}")
    public abstract List<String> getID(@Param("start") Integer start,@Param("end") Integer end);


    }
