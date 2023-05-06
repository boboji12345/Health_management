package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Radmins implements Serializable {
    private Integer rid;

    private String rname;

    private String rpwd;

    private String rtel;

    private int code;
    private String msg;
    private Object obj;

    public Radmins(){

    }

    public Radmins(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Radmins(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Radmins getJsonResult(int code,String msg,Object obj){
        return new Radmins(code,msg,obj);
    }

    public static Radmins getJsonResult(int code,String msg){
        return new Radmins(code,msg);
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

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getRpwd() {
        return rpwd;
    }

    public void setRpwd(String rpwd) {
        this.rpwd = rpwd == null ? null : rpwd.trim();
    }

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel == null ? null : rtel.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rid=").append(rid);
        sb.append(", rname=").append(rname);
        sb.append(", rpwd=").append(rpwd);
        sb.append(", rtel=").append(rtel);
        sb.append("]");
        return sb.toString();
    }
}