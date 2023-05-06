package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Rteachers implements Serializable {
    private Integer tuid;

    private String tuimg;

    private String tuname;

    private String tupwd;

    private String tutel;

    private String tusex;

    private String tuage;

    private String tushen;

    private Integer tubid;

    private String tuids;

    private String bname;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
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

    public Rteachers(){

    }

    public Rteachers(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rteachers(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rteachers getJsonResult(int code,String msg,Object obj){
        return new Rteachers(code,msg,obj);
    }

    public static Rteachers getJsonResult(int code,String msg){
        return new Rteachers(code,msg);
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

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public String getTuimg() {
        return tuimg;
    }

    public void setTuimg(String tuimg) {
        this.tuimg = tuimg == null ? null : tuimg.trim();
    }

    public String getTuname() {
        return tuname;
    }

    public void setTuname(String tuname) {
        this.tuname = tuname == null ? null : tuname.trim();
    }

    public String getTupwd() {
        return tupwd;
    }

    public void setTupwd(String tupwd) {
        this.tupwd = tupwd == null ? null : tupwd.trim();
    }

    public String getTutel() {
        return tutel;
    }

    public void setTutel(String tutel) {
        this.tutel = tutel == null ? null : tutel.trim();
    }

    public String getTusex() {
        return tusex;
    }

    public void setTusex(String tusex) {
        this.tusex = tusex == null ? null : tusex.trim();
    }

    public String getTuage() {
        return tuage;
    }

    public void setTuage(String tuage) {
        this.tuage = tuage == null ? null : tuage.trim();
    }

    public String getTushen() {
        return tushen;
    }

    public void setTushen(String tushen) {
        this.tushen = tushen == null ? null : tushen.trim();
    }

    public Integer getTubid() {
        return tubid;
    }

    public void setTubid(Integer tubid) {
        this.tubid = tubid;
    }

    public String getTuids() {
        return tuids;
    }

    public void setTuids(String tuids) {
        this.tuids = tuids == null ? null : tuids.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tuid=").append(tuid);
        sb.append(", tuimg=").append(tuimg);
        sb.append(", tuname=").append(tuname);
        sb.append(", tupwd=").append(tupwd);
        sb.append(", tutel=").append(tutel);
        sb.append(", tusex=").append(tusex);
        sb.append(", tuage=").append(tuage);
        sb.append(", tushen=").append(tushen);
        sb.append(", tubid=").append(tubid);
        sb.append(", tuids=").append(tuids);
        sb.append(", bname=").append(bname);
        sb.append("]");
        return sb.toString();
    }
}