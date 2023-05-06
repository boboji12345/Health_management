package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Rtypes implements Serializable {
    private Integer rtid;

    private String rtname;

    private String rtimg;

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

    public Rtypes(){

    }

    public Rtypes(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rtypes(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rtypes getJsonResult(int code,String msg,Object obj){
        return new Rtypes(code,msg,obj);
    }

    public static Rtypes getJsonResult(int code,String msg){
        return new Rtypes(code,msg);
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

    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
    }

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname == null ? null : rtname.trim();
    }

    public String getRtimg() {
        return rtimg;
    }

    public void setRtimg(String rtimg) {
        this.rtimg = rtimg == null ? null : rtimg.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rtid=").append(rtid);
        sb.append(", rtname=").append(rtname);
        sb.append(", rtimg=").append(rtimg);
        sb.append("]");
        return sb.toString();
    }
}