package com.dreamkong.pracricewearher.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author bsbj
 * @date 2017/12/6.
 */

public class Weather {
    /**
     * basic : {"cid":"CN101010100","location":"北京","parent_city":"北京","admin_area":"北京","cnty":"中国","lat":"39.90498734","lon":"116.4052887","tz":"+8.0"}
     * update : {"loc":"2017-12-06 09:50","utc":"2017-12-06 01:50"}
     * status : ok
     * now : {"cloud":"0","cond_code":"104","cond_txt":"阴","fl":"-3","hum":"37","pcpn":"0","pres":"1020","tmp":"2","vis":"8","wind_deg":"229","wind_dir":"西南风","wind_sc":"微风","wind_spd":"5"}
     * daily_forecast : [{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2017-12-06","hum":"23","mr":"19:50","ms":"09:42","pcpn":"0.0","pop":"0","pres":"1023","sr":"07:20","ss":"16:51","tmp_max":"8","tmp_min":"-4","uv_index":"1","vis":"20","wind_deg":"353","wind_dir":"北风","wind_sc":"微风","wind_spd":"6"},{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2017-12-07","hum":"26","mr":"20:58","ms":"10:36","pcpn":"0.0","pop":"0","pres":"1032","sr":"07:21","ss":"16:51","tmp_max":"5","tmp_min":"-5","uv_index":"1","vis":"20","wind_deg":"359","wind_dir":"北风","wind_sc":"微风","wind_spd":"7"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-12-08","hum":"21","mr":"22:07","ms":"11:23","pcpn":"0.0","pop":"0","pres":"1028","sr":"07:22","ss":"16:51","tmp_max":"6","tmp_min":"-4","uv_index":"1","vis":"20","wind_deg":"204","wind_dir":"西南风","wind_sc":"微风","wind_spd":"6"}]
     * lifestyle : [{"brf":"较舒适","txt":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。","type":"comf"},{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","type":"drsg"},{"brf":"较易发","txt":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。","type":"flu"},{"brf":"较适宜","txt":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。","type":"sport"},{"brf":"适宜","txt":"天气较好，气温稍低，会感觉稍微有点凉，不过也是个好天气哦。适宜旅游，可不要错过机会呦！","type":"trav"},{"brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。","type":"uv"},{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","type":"cw"},{"brf":"中","txt":"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。","type":"air"}]
     */

    private Basic basic;
    private Update update;
    private String status;
    private Now now;
    @SerializedName("daily_forecast")
    private List<Forecast> forecast;
    private List<Lifestyle> lifestyle;

    public Basic getBasic() {
        return basic;
    }

    public void setBasic(Basic basic) {
        this.basic = basic;
    }

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Now getNow() {
        return now;
    }

    public void setNow(Now now) {
        this.now = now;
    }

    public List<Forecast> getDaily_forecast() {
        return forecast;
    }

    public void setDaily_forecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public List<Lifestyle> getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(List<Lifestyle> lifestyle) {
        this.lifestyle = lifestyle;
    }
}
