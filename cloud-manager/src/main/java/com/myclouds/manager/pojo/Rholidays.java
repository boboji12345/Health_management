package com.myclouds.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Rholidays implements Serializable {
    private Integer hid;

    private Integer huid;

    private Date hdate;

    private String hcont;

    private Integer hflag;

    private String hteacherresult;

    private String hadminresult;

    private Integer hbid;

    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    private String uimg;
    private String uname;
    private String utel;

    private String bname;
    private String tuname;

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

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getTuname() {
        return tuname;
    }

    public void setTuname(String tuname) {
        this.tuname = tuname;
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

    public Rholidays(){

    }

    public Rholidays(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rholidays(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rholidays getJsonResult(int code,String msg,Object obj){
        return new Rholidays(code,msg,obj);
    }

    public static Rholidays getJsonResult(int code,String msg){
        return new Rholidays(code,msg);
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

    private static final long serialVersionUID = 1L;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Integer getHuid() {
        return huid;
    }

    public void setHuid(Integer huid) {
        this.huid = huid;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }

    public String getHcont() {
        return hcont;
    }

    public void setHcont(String hcont) {
        this.hcont = hcont == null ? null : hcont.trim();
    }

    public Integer getHflag() {
        return hflag;
    }

    public void setHflag(Integer hflag) {
        this.hflag = hflag;
    }

    public String getHteacherresult() {
        return hteacherresult;
    }

    public void setHteacherresult(String hteacherresult) {
        this.hteacherresult = hteacherresult == null ? null : hteacherresult.trim();
    }

    public String getHadminresult() {
        return hadminresult;
    }

    public void setHadminresult(String hadminresult) {
        this.hadminresult = hadminresult == null ? null : hadminresult.trim();
    }

    public Integer getHbid() {
        return hbid;
    }

    public void setHbid(Integer hbid) {
        this.hbid = hbid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hid=").append(hid);
        sb.append(", huid=").append(huid);
        sb.append(", hdate=").append(hdate);
        sb.append(", hcont=").append(hcont);
        sb.append(", hflag=").append(hflag);
        sb.append(", hteacherresult=").append(hteacherresult);
        sb.append(", hadminresult=").append(hadminresult);
        sb.append(", hbid=").append(hbid);
        sb.append(", bid=").append(bid);

        sb.append(", uimg=").append(uimg);
        sb.append(", uname=").append(uname);
        sb.append(", utel=").append(utel);
        sb.append(", bname=").append(bname);
        sb.append(", tuname=").append(tuname);
        sb.append("]");
        return sb.toString();
    }
}