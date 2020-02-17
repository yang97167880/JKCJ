package com.jkcj.DO;

import java.util.Date;

public class AD_DataDO {
    private Integer adChannel;

    private String data;

    private Date time;

    public Integer getAdChannel() {
        return adChannel;
    }

    public void setAdChannel(Integer adChannel) {
        this.adChannel = adChannel;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}