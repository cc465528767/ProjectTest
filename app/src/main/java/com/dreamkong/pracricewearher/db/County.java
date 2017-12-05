package com.dreamkong.pracricewearher.db;

import org.litepal.crud.DataSupport;

/**
 * @author bsbj
 * @date 2017/12/5.
 */

public class County extends DataSupport {

    private int id;
    private String countyName;
    private String weatherId;
    private int cityCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeacherId() {
        return weatherId;
    }

    public void setWeacherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }
}
