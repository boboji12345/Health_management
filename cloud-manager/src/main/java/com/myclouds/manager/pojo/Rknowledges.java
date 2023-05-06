package com.myclouds.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Rknowledges implements Serializable {
    private Integer rkid;

    private String rktitle;

    private String rkinstroduces;

    private String rkimg;

    private Date rdate;

    private String rkcont;

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

    public Rknowledges(){

    }

    public Rknowledges(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rknowledges(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rknowledges getJsonResult(int code,String msg,Object obj){
        return new Rknowledges(code,msg,obj);
    }

    public static Rknowledges getJsonResult(int code,String msg){
        return new Rknowledges(code,msg);
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

    public Integer getRkid() {
        return rkid;
    }

    public void setRkid(Integer rkid) {
        this.rkid = rkid;
    }

    public String getRktitle() {
        return rktitle;
    }

    public void setRktitle(String rktitle) {
        this.rktitle = rktitle == null ? null : rktitle.trim();
    }

    public String getRkinstroduces() {
        return rkinstroduces;
    }

    public void setRkinstroduces(String rkinstroduces) {
        this.rkinstroduces = rkinstroduces == null ? null : rkinstroduces.trim();
    }

    public String getRkimg() {
        return rkimg;
    }

    public void setRkimg(String rkimg) {
        this.rkimg = rkimg == null ? null : rkimg.trim();
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getRkcont() {
        return rkcont;
    }

    public void setRkcont(String rkcont) {
        this.rkcont = rkcont == null ? null : rkcont.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rkid=").append(rkid);
        sb.append(", rktitle=").append(rktitle);
        sb.append(", rkinstroduces=").append(rkinstroduces);
        sb.append(", rkimg=").append(rkimg);
        sb.append(", rdate=").append(rdate);
        sb.append(", rkcont=").append(rkcont);
        sb.append("]");
        return sb.toString();
    }
}