package com.myclouds.manager.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PageBean<T>	{

	private int page; //当前页码，从1开始
	private int pagesize; //分页大小
	private int totalpages; //总页数
	private int totalrecords; //总记录数
	private List<T> list;
	//构造函数中计算总页数
	public PageBean(int page, int pagesize, int totalrecords, List<T> list){
		this.page = page;
		this.pagesize = pagesize;
		this.totalrecords = totalrecords;
		this.list = list;
		//计算总页数
		this.totalpages = totalrecords/pagesize;
		if(totalrecords%pagesize!=0){
			this.totalpages = this.totalpages + 1;
		};
	}


}
