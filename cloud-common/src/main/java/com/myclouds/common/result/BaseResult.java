package com.myclouds.common.result;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.myclouds.common.enums.BaseResultEnum;

import java.io.Serializable;

public class BaseResult implements Serializable {
    private Integer code;
    private String message;
    PageInfo<?> pageInfo;

    public static BaseResult success(){
        BaseResult result = new BaseResult();
        result.setCode(BaseResultEnum.SUCCESS.getCode());
        result.setMessage(BaseResultEnum.SUCCESS.getMessage());
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PageInfo<?> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<?> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
