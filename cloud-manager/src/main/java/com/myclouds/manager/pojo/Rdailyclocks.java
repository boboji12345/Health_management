package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Rdailyclocks implements Serializable {
    private Integer pid;

    private String pdate;

    private String pattr;

    private String ptemperature;

    private Integer puid;

    private String puzhengjianhaoma;

    private String plaiyuan;

    private String pshentizhuangkuang;

    private Integer bid;

    private String uimg;

    private String uname;

    private String utel;

    private String uroomnumber;

    private int echarts1;
    private int echarts2;
    private int echarts3;
    private int echarts4;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public int getEcharts1() {
        return echarts1;
    }

    public void setEcharts1(int echarts1) {
        this.echarts1 = echarts1;
    }

    public int getEcharts2() {
        return echarts2;
    }

    public void setEcharts2(int echarts2) {
        this.echarts2 = echarts2;
    }

    public int getEcharts3() {
        return echarts3;
    }

    public void setEcharts3(int echarts3) {
        this.echarts3 = echarts3;
    }

    public int getEcharts4() {
        return echarts4;
    }

    public void setEcharts4(int echarts4) {
        this.echarts4 = echarts4;
    }

    private int currpage;
    private int currpagenums;

    public int getCurrpage() {
        return currpage;
    }

    public void setCurrpage(int currpage) {
        this.currpage = currpage;
    }

    public int getCurrpagenums() {
        return currpagenums;
    }

    public void setCurrpagenums(int currpagenums) {
        this.currpagenums = currpagenums;
    }

    private int code;
    private String msg;
    private Object obj;

    public Rdailyclocks(){

    }

    public Rdailyclocks(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rdailyclocks(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rdailyclocks getJsonResult(int code,String msg,Object obj){
        return new Rdailyclocks(code,msg,obj);
    }

    public static Rdailyclocks getJsonResult(int code,String msg){
        return new Rdailyclocks(code,msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUroomnumber() {
        return uroomnumber;
    }

    public void setUroomnumber(String uroomnumber) {
        this.uroomnumber = uroomnumber;
    }

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate == null ? null : pdate.trim();
    }

    public String getPattr() {
        return pattr;
    }

    public void setPattr(String pattr) {
        this.pattr = pattr == null ? null : pattr.trim();
    }

    public String getPtemperature() {
        return ptemperature;
    }

    public void setPtemperature(String ptemperature) {
        this.ptemperature = ptemperature == null ? null : ptemperature.trim();
    }

    public Integer getPuid() {
        return puid;
    }

    public void setPuid(Integer puid) {
        this.puid = puid;
    }

    public String getPuzhengjianhaoma() {
        return puzhengjianhaoma;
    }

    public void setPuzhengjianhaoma(String puzhengjianhaoma) {
        this.puzhengjianhaoma = puzhengjianhaoma == null ? null : puzhengjianhaoma.trim();
    }

    public String getPlaiyuan() {
        return plaiyuan;
    }

    public void setPlaiyuan(String plaiyuan) {
        this.plaiyuan = plaiyuan == null ? null : plaiyuan.trim();
    }

    public String getPshentizhuangkuang() {
        return pshentizhuangkuang;
    }

    public void setPshentizhuangkuang(String pshentizhuangkuang) {
        this.pshentizhuangkuang = pshentizhuangkuang == null ? null : pshentizhuangkuang.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", pdate=").append(pdate);
        sb.append(", pattr=").append(pattr);
        sb.append(", ptemperature=").append(ptemperature);
        sb.append(", puid=").append(puid);
        sb.append(", puzhengjianhaoma=").append(puzhengjianhaoma);
        sb.append(", plaiyuan=").append(plaiyuan);
        sb.append(", pshentizhuangkuang=").append(pshentizhuangkuang);
        sb.append(", bid=").append(bid);

        sb.append(", echarts1=").append(echarts1);
        sb.append(", echarts2=").append(echarts2);
        sb.append(", echarts3=").append(echarts3);
        sb.append(", echarts4=").append(echarts4);

        sb.append(", uimg=").append(uimg);
        sb.append(", uname=").append(uname);
        sb.append(", utel=").append(utel);
        sb.append(", uroomnumber=").append(uroomnumber);
        sb.append("]");
        return sb.toString();
    }
}