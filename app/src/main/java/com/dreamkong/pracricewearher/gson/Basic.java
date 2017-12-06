package com.dreamkong.pracricewearher.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author bsbj
 * @date 2017/12/6.
 */

public class Basic {

    /**
     * cid : CN101010100
     * location : 北京
     * parent_city : 北京
     * admin_area : 北京
     * cnty : 中国
     * lat : 39.90498734
     * lon : 116.4052887
     * tz : +8.0
     */

    private String cid;
    private String location;
    @SerializedName("parent_city")
    private String parentCity;
    @SerializedName("admin_area")
    private String adminArea;
    private String cnty;
    private String lat;
    private String lon;
    private String tz;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getParentCity() {
        return parentCity;
    }

    public void setParentCity(String parentCity) {
        this.parentCity = parentCity;
    }

    public String getAdminArea() {
        return adminArea;
    }

    public void setAdminArea(String adminArea) {
        this.adminArea = adminArea;
    }

    public String getCnty() {
        return cnty;
    }

    public void setCnty(String cnty) {
        this.cnty = cnty;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }
}
