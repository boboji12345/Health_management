package com.myclouds.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Rinoutsigns implements Serializable {
    private Integer cid;

    private Date cdate;

    private Integer ctype;

    private String ctemperature;

    private Integer cuid;

    private String ctypename;

    private String cuzhengjianhaoma;

    private String cfromattrs;

    private String cshentizhuangkuang;

    private String ctoattrs;

    private String uimg;

    private String uname;

    private String utel;

    private String uroomnumber;

    private Integer bid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public Rinoutsigns(){

    }

    public Rinoutsigns(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rinoutsigns(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rinoutsigns getJsonResult(int code,String msg,Object obj){
        return new Rinoutsigns(code,msg,obj);
    }

    public static Rinoutsigns getJsonResult(int code,String msg){
        return new Rinoutsigns(code,msg);
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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Integer getCtype() {
        return ctype;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public String getCtemperature() {
        return ctemperature;
    }

    public void setCtemperature(String ctemperature) {
        this.ctemperature = ctemperature == null ? null : ctemperature.trim();
    }

    public Integer getCuid() {
        return cuid;
    }

    public void setCuid(Integer cuid) {
        this.cuid = cuid;
    }

    public String getCtypename() {
        return ctypename;
    }

    public void setCtypename(String ctypename) {
        this.ctypename = ctypename == null ? null : ctypename.trim();
    }

    public String getCuzhengjianhaoma() {
        return cuzhengjianhaoma;
    }

    public void setCuzhengjianhaoma(String cuzhengjianhaoma) {
        this.cuzhengjianhaoma = cuzhengjianhaoma == null ? null : cuzhengjianhaoma.trim();
    }

    public String getCfromattrs() {
        return cfromattrs;
    }

    public void setCfromattrs(String cfromattrs) {
        this.cfromattrs = cfromattrs == null ? null : cfromattrs.trim();
    }

    public String getCshentizhuangkuang() {
        return cshentizhuangkuang;
    }

    public void setCshentizhuangkuang(String cshentizhuangkuang) {
        this.cshentizhuangkuang = cshentizhuangkuang == null ? null : cshentizhuangkuang.trim();
    }

    public String getCtoattrs() {
        return ctoattrs;
    }

    public void setCtoattrs(String ctoattrs) {
        this.ctoattrs = ctoattrs == null ? null : ctoattrs.trim();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", cdate=").append(cdate);
        sb.append(", ctype=").append(ctype);
        sb.append(", ctemperature=").append(ctemperature);
        sb.append(", cuid=").append(cuid);
        sb.append(", ctypename=").append(ctypename);
        sb.append(", cuzhengjianhaoma=").append(cuzhengjianhaoma);
        sb.append(", cfromattrs=").append(cfromattrs);
        sb.append(", cshentizhuangkuang=").append(cshentizhuangkuang);
        sb.append(", ctoattrs=").append(ctoattrs);
        sb.append(", bid=").append(bid);

        sb.append(", uimg=").append(uimg);
        sb.append(", uname=").append(uname);
        sb.append(", utel=").append(utel);
        sb.append(", uroomnumber=").append(uroomnumber);
        sb.append("]");
        return sb.toString();
    }
}