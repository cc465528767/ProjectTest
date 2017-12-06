package com.dreamkong.pracricewearher.gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author bsbj
 * @date 2017/12/6.
 */

public class Forecast {

    /**
     * cond_code_d : 100
     * cond_code_n : 101
     * cond_txt_d : 晴
     * cond_txt_n : 多云
     * date : 2017-12-06
     * hum : 23
     * mr : 19:50
     * ms : 09:42
     * pcpn : 0.0
     * pop : 0
     * pres : 1023
     * sr : 07:20
     * ss : 16:51
     * tmp_max : 8
     * tmp_min : -4
     * uv_index : 1
     * vis : 20
     * wind_deg : 353
     * wind_dir : 北风
     * wind_sc : 微风
     * wind_spd : 6
     */

    @SerializedName("cond_code_d")
    private String condCodeD;
    @SerializedName("cond_code_n")
    private String condCodeN;
    @SerializedName("cond_txt_d")
    private String condTxtD;
    @SerializedName("cond_txt_n")
    private String condTxtN;
    private String date;
    private String hum;
    private String mr;
    private String ms;
    private String pcpn;
    private String pop;
    private String pres;
    private String sr;
    private String ss;
    @SerializedName("tmp_max")
    private String tmpMax;
    @SerializedName("tmp_min")
    private String tmpMin;
    @SerializedName("uv_index")
    private String uvIndex;
    private String vis;
    @SerializedName("wind_deg")
    private String windDeg;
    @SerializedName("wind_dir")
    private String windDir;
    @SerializedName("wind_sc")
    private String windSc;
    @SerializedName("wind_spd")
    private String windSpd;

    public String getCondCodeD() {
        return condCodeD;
    }

    public void setCondCodeD(String condCodeD) {
        this.condCodeD = condCodeD;
    }

    public String getCondCodeN() {
        return condCodeN;
    }

    public void setCondCodeN(String condCodeN) {
        this.condCodeN = condCodeN;
    }

    public String getCondTxtD() {
        return condTxtD;
    }

    public void setCondTxtD(String condTxtD) {
        this.condTxtD = condTxtD;
    }

    public String getCondTxtN() {
        return condTxtN;
    }

    public void setCondTxtN(String condTxtN) {
        this.condTxtN = condTxtN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getMr() {
        return mr;
    }

    public void setMr(String mr) {
        this.mr = mr;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getSr() {
        return sr;
    }

    public void setSr(String sr) {
        this.sr = sr;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getTmpMax() {
        return tmpMax;
    }

    public void setTmpMax(String tmpMax) {
        this.tmpMax = tmpMax;
    }

    public String getTmpMin() {
        return tmpMin;
    }

    public void setTmpMin(String tmpMin) {
        this.tmpMin = tmpMin;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }

    public String getWindDeg() {
        return windDeg;
    }

    public void setWindDeg(String windDeg) {
        this.windDeg = windDeg;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindSc() {
        return windSc;
    }

    public void setWindSc(String windSc) {
        this.windSc = windSc;
    }

    public String getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(String windSpd) {
        this.windSpd = windSpd;
    }
}
