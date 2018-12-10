package com.example.demojziyy1207.Beans;

import java.io.Serializable;

public class Statistics implements Serializable{
	private String path;
	private String username;
	private String url;
	private String name;			//接口名
	private String appchname;		//项目名
	private String id;
	private String conid;
	private String userid;			//用户名或用户id
	private String success;			//访问是否成功
	private String channel;			//访问渠道
	private String starttime;		//访问开始时间
	private String endtime;			//访问结束时间
	private String errormsg;		//访问错误信息
	private String arg;				//请求参数
	private String rspmsg;			//返回信息
	private String time;			//时间戳
	private String phonemodel;		//手机型号
	private String opersystem;		//手机操作系统
	private String appid;			//应用id
	private String clientip;		//客户端请求ip

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getConid() {
		return conid;
	}
	public void setConid(String conid) {
		this.conid = conid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getArg() {
		return arg;
	}
	public void setArg(String arg) {
		this.arg = arg;
	}
	public String getRspmsg() {
		return rspmsg;
	}
	public void setRspmsg(String rspmsg) {
		this.rspmsg = rspmsg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhonemodel() {
		return phonemodel;
	}
	public void setPhonemodel(String phonemodel) {
		this.phonemodel = phonemodel;
	}
	public String getOpersystem() {
		return opersystem;
	}
	public void setOpersystem(String opersystem) {
		this.opersystem = opersystem;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAppchname() {
		return appchname;
	}

	public void setAppchname(String appchname) {
		this.appchname = appchname;
	}

	@Override
	public String toString() {
		return "Statistics{" +
				"username='" + username + '\'' +
				", url='" + url + '\'' +
				", name='" + name + '\'' +
				", appchname='" + appchname + '\'' +
				", id='" + id + '\'' +
				", conid='" + conid + '\'' +
				", userid='" + userid + '\'' +
				", success='" + success + '\'' +
				", channel='" + channel + '\'' +
				", starttime='" + starttime + '\'' +
				", endtime='" + endtime + '\'' +
				", errormsg='" + errormsg + '\'' +
				", arg='" + arg + '\'' +
				", rspmsg='" + rspmsg + '\'' +
				", time='" + time + '\'' +
				", phonemodel='" + phonemodel + '\'' +
				", opersystem='" + opersystem + '\'' +
				", appid='" + appid + '\'' +
				", clientip='" + clientip + '\'' +
				'}';
	}
}
