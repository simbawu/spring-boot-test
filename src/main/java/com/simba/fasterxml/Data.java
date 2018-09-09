/**
  * Copyright 2018 bejson.com 
  */
package com.simba.fasterxml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2018-09-09 17:9:26
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    @JsonProperty("RowNumber")
    private int rowNumber;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ParentCode")
    private String parentCode;
    @JsonProperty("LineNum")
    private String lineNum;
    @JsonProperty("TrandingFlag")
    private int trandingFlag;
    @JsonProperty("WsType")
    private int wsType;

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public int getTrandingFlag() {
        return trandingFlag;
    }

    public void setTrandingFlag(int trandingFlag) {
        this.trandingFlag = trandingFlag;
    }

    public int getWsType() {
        return wsType;
    }

    public void setWsType(int wsType) {
        this.wsType = wsType;
    }
}