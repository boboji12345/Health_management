package com.myclouds.manager.pojo;

import java.io.Serializable;

public class Rclocknotificats implements Serializable {
    private Integer nid;

    private String ntitle;

    private String ndate;

    private String nstarthour;

    private String nendhour;

    private int uflag;

    private String ncurrdate;

    public int getUflag() {
        return uflag;
    }

    public void setUflag(int uflag) {
        this.uflag = uflag;
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

    public String getNcurrdate() {
        return ncurrdate;
    }

    public void setNcurrdate(String ncurrdate) {
        this.ncurrdate = ncurrdate;
    }

    private int code;
    private String msg;
    private Object obj;

    public Rclocknotificats(){

    }

    public Rclocknotificats(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rclocknotificats(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rclocknotificats getJsonResult(int code,String msg,Object obj){
        return new Rclocknotificats(code,msg,obj);
    }

    public static Rclocknotificats getJsonResult(int code,String msg){
        return new Rclocknotificats(code,msg);
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

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle == null ? null : ntitle.trim();
    }

    public String getNdate() {
        return ndate;
    }

    public void setNdate(String ndate) {
        this.ndate = ndate == null ? null : ndate.trim();
    }

    public String getNstarthour() {
        return nstarthour;
    }

    public void setNstarthour(String nstarthour) {
        this.nstarthour = nstarthour == null ? null : nstarthour.trim();
    }

    public String getNendhour() {
        return nendhour;
    }

    public void setNendhour(String nendhour) {
        this.nendhour = nendhour == null ? null : nendhour.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nid=").append(nid);
        sb.append(", ntitle=").append(ntitle);
        sb.append(", ndate=").append(ndate);
        sb.append(", nstarthour=").append(nstarthour);
        sb.append(", nendhour=").append(nendhour);
        sb.append(", ncurrdate=").append(ncurrdate);
        sb.append("]");
        return sb.toString();
    }
}