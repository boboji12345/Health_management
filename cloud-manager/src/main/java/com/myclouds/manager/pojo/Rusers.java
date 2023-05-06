package com.myclouds.manager.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

public class Rusers implements Serializable {
    private Integer uid;

    private String uimg;
    @Excel(name = "学生姓名", orderNum = "0")
    private String uname;

    private String upwd;
    @Excel(name = "学生电话", orderNum = "1")
    private String utel;
    @Excel(name = "学生性别", orderNum = "4")
    private String usex;
    @Excel(name = "学生年龄", orderNum = "5")
    private String uage;
    @Excel(name = "学生宿舍号", orderNum = "6")
    private String uroomnumber;
    @Excel(name = "学生学号", orderNum = "3")
    private String ustuids;
    @Excel(name = "身份证号", orderNum = "7")
    private String ushen;
    @Excel(name = "所在班级id", orderNum = "9")
    private Integer ubid;
    @Excel(name = "所在班级", orderNum = "8")
    private String bname;

    private Integer uflag;
    private String udailyclockdate;

    public Integer getUflag() {
        return uflag;
    }

    public void setUflag(Integer uflag) {
        this.uflag = uflag;
    }

    public String getUdailyclockdate() {
        return udailyclockdate;
    }

    public void setUdailyclockdate(String udailyclockdate) {
        this.udailyclockdate = udailyclockdate;
    }

    public Integer getUbid() {
        return ubid;
    }

    public void setUbid(Integer ubid) {
        this.ubid = ubid;
    }

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

    public Rusers(){

    }

    public Rusers(int code,String msg,Object obj){
        this.code=code;
        this.msg=msg;
        this.obj=obj;
    }

    public Rusers(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public static Rusers getJsonResult(int code,String msg,Object obj){
        return new Rusers(code,msg,obj);
    }

    public static Rusers getJsonResult(int code,String msg){
        return new Rusers(code,msg);
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUimg() {
        return uimg;
    }

    public void setUimg(String uimg) {
        this.uimg = uimg == null ? null : uimg.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel == null ? null : utel.trim();
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex == null ? null : usex.trim();
    }

    public String getUage() {
        return uage;
    }

    public void setUage(String uage) {
        this.uage = uage == null ? null : uage.trim();
    }

    public String getUroomnumber() {
        return uroomnumber;
    }

    public void setUroomnumber(String uroomnumber) {
        this.uroomnumber = uroomnumber == null ? null : uroomnumber.trim();
    }

    public String getUstuids() {
        return ustuids;
    }

    public void setUstuids(String ustuids) {
        this.ustuids = ustuids == null ? null : ustuids.trim();
    }

    public String getUshen() {
        return ushen;
    }

    public void setUshen(String ushen) {
        this.ushen = ushen == null ? null : ushen.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", uid=").append(uid);
        sb.append(", uimg=").append(uimg);
        sb.append(", uname=").append(uname);
        sb.append(", upwd=").append(upwd);
        sb.append(", utel=").append(utel);
        sb.append(", usex=").append(usex);
        sb.append(", uage=").append(uage);
        sb.append(", uroomnumber=").append(uroomnumber);
        sb.append(", ustuids=").append(ustuids);
        sb.append(", ushen=").append(ushen);
        sb.append(", ubid=").append(ubid);
        sb.append(", bname=").append(bname);
        sb.append(", udailyclockdate=").append(udailyclockdate);
        sb.append(", uflag=").append(uflag);
        sb.append("]");
        return sb.toString();
    }
}