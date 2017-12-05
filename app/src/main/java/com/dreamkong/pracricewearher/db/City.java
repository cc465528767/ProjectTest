package com.dreamkong.pracricewearher.db;

import org.litepal.crud.DataSupport;

/**
 * @author bsbj
 * @date 2017/12/5.
 */

public class City extends DataSupport {

    private int id;
    private String cityName;
    private int cityCode;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProcinceCode() {
        return provinceCode;
    }

    public void setProcinceCode(int procinceCode) {
        this.provinceCode = procinceCode;
    }
}
