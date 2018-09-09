/**
  * Copyright 2018 bejson.com 
  */
package com.simba.fasterxml;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Auto-generated: 2018-09-09 17:9:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Msg {

    @JsonProperty("Data")
    private List<Data> data;
    @JsonProperty("TotalCount")
    private int totalCount;
    @JsonProperty("PageIndex")
    private int pageIndex;
    @JsonProperty("PageCount")
    private int pageCount;
    @JsonProperty("LimitNum")
    private String limitNum;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(String limitNum) {
        this.limitNum = limitNum;
    }
}