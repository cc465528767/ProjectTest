package com.dreamkong.pracricewearher.gson;

/**
 * @author bsbj
 * @date 2017/12/6.
 */

public class Lifestyle {

    /**
     * brf : 较舒适
     * txt : 白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。
     * type : comf
     */

    private String brf;
    private String txt;
    private String type;

    public String getBrf() {
        return brf;
    }

    public void setBrf(String brf) {
        this.brf = brf;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
