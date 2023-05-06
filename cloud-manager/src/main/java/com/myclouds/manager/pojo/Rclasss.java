package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Rclasss implements Serializable {
    private Integer bid;

    private String bname;

    private int code;
    private String msg;
    private Object obj;

    public Rclasss(){

    }

    public Rclasss(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rclasss(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rclasss getJsonResult(int code,String msg,Object obj){
        return new Rclasss(code,msg,obj);
    }

    public static Rclasss getJsonResult(int code,String msg){
        return new Rclasss(code,msg);
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bid=").append(bid);
        sb.append(", bname=").append(bname);
        sb.append("]");
        return sb.toString();
    }
}