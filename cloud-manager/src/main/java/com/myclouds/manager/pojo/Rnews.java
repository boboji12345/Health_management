package com.myclouds.manager.pojo;

import java.io.Serializable;
import java.util.Date;

public class Rnews implements Serializable {
    private Integer rnid;

    private String rntitle;

    private String rinstroduces;

    private String rimg;

    private Integer rtid;

    private Date rdate;

    private String rcont;

    private String rtname;

    private Integer rnums;

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

    public Rnews(){

    }

    public Rnews(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rnews(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rnews getJsonResult(int code,String msg,Object obj){
        return new Rnews(code,msg,obj);
    }

    public static Rnews getJsonResult(int code,String msg){
        return new Rnews(code,msg);
    }

    public Integer getRnums() {
        return rnums;
    }

    public void setRnums(Integer rnums) {
        this.rnums = rnums;
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

    public String getRtname() {
        return rtname;
    }

    public void setRtname(String rtname) {
        this.rtname = rtname;
    }

    public Integer getRnid() {
        return rnid;
    }

    public void setRnid(Integer rnid) {
        this.rnid = rnid;
    }

    public String getRntitle() {
        return rntitle;
    }

    public void setRntitle(String rntitle) {
        this.rntitle = rntitle == null ? null : rntitle.trim();
    }

    public String getRinstroduces() {
        return rinstroduces;
    }

    public void setRinstroduces(String rinstroduces) {
        this.rinstroduces = rinstroduces == null ? null : rinstroduces.trim();
    }

    public String getRimg() {
        return rimg;
    }

    public void setRimg(String rimg) {
        this.rimg = rimg == null ? null : rimg.trim();
    }

    public Integer getRtid() {
        return rtid;
    }

    public void setRtid(Integer rtid) {
        this.rtid = rtid;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getRcont() {
        return rcont;
    }

    public void setRcont(String rcont) {
        this.rcont = rcont == null ? null : rcont.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rnid=").append(rnid);
        sb.append(", rntitle=").append(rntitle);
        sb.append(", rinstroduces=").append(rinstroduces);
        sb.append(", rimg=").append(rimg);
        sb.append(", rtid=").append(rtid);
        sb.append(", rdate=").append(rdate);
        sb.append(", rcont=").append(rcont);
        sb.append(", rtname=").append(rtname);
        sb.append(", rnums=").append(rnums);
        sb.append("]");
        return sb.toString();
    }
}