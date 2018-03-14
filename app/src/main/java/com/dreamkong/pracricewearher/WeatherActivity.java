package com.dreamkong.pracricewearher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dreamkong.pracricewearher.gson.Forecast;
import com.dreamkong.pracricewearher.gson.Lifestyle;
import com.dreamkong.pracricewearher.gson.Weather;
import com.dreamkong.pracricewearher.service.AutoUpdateService;
import com.dreamkong.pracricewearher.util.HttpUtil;
import com.dreamkong.pracricewearher.util.Utility;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.os.Build.VERSION_CODES.LOLLIPOP;

public class WeatherActivity extends AppCompatActivity {

    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.title_city)
    TextView titleCity;
    @BindView(R.id.title_update_time)
    TextView titleUpdateTime;
    @BindView(R.id.degree_text)
    TextView degreeText;
    @BindView(R.id.weather_info_text)
    TextView weatherInfoText;
    @BindView(R.id.forecast_layout)
    LinearLayout forecastLayout;
    @BindView(R.id.comfort_text)
    TextView comfortText;
    @BindView(R.id.uv_text)
    TextView uvText;
    @BindView(R.id.sport_text)
    TextView sportText;
    @BindView(R.id.wash_text)
    TextView washText;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.scroll_layout)
    ScrollView scrollLayout;
    @BindView(R.id.nav_button)
    Button navButton;

    private String mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= LOLLIPOP) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String bingPic = preferences.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(this).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
        String weatherString = preferences.getString("weather", null);
        if (weatherString != null) {
            // 有缓存时候直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherString);
            if (weather != null)
                mLocation = weather.getBasic().getLocation();
            showWeatherInfo(weather);
        } else {
            // 无缓存时候去服务器查询天气
            mLocation = getIntent().getStringExtra("location");
            scrollLayout.setVisibility(View.GONE);
            requestWeather(mLocation);
        }
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(mLocation);
            }
        });
    }

    /**
     * 加载Bing每日一图
     */
    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }
        });
    }

    /**
     * 根据天气id请求城市天气信息
     *
     * @param location 位置
     */
    public void requestWeather(String location) {
        // https://free-api.heweather.com/s6/weather?key=f5ce9a9ae183445c8aa63e2c71012462&location=%E5%8C%97%E4%BA%AC
        final String weatherUrl = "https://free-api.heweather.com/s6/weather?key=f5ce9a9ae183445c8aa63e2c71012462&location=" + location;
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取信息失败", Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String responseText = response.body().string();
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.getStatus())) {
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather", responseText);
//                            editor.putString("location", mLocation);
                            editor.apply();
                            mLocation = weather.getBasic().getLocation();
                            showWeatherInfo(weather);
                        } else {
                            Toast.makeText(WeatherActivity.this, "获取信息失败", Toast.LENGTH_SHORT).show();
                        }
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });
    }

    /**
     * 处理并展示Weather实体类中的数据
     */
    private void showWeatherInfo(Weather weather) {
        if (weather != null && "ok".equals(weather.getStatus())) {
            String cityName = weather.getBasic().getLocation();
            String updateTime = weather.getUpdate().getLoc();
            String degree = weather.getNow().getTmp() + "度";
            String weatherInfo = weather.getNow().getCondTxt();

            titleCity.setText(cityName);
            titleUpdateTime.setText(updateTime);
            degreeText.setText(degree);
            weatherInfoText.setText(weatherInfo);

            forecastLayout.removeAllViews();
            for (Forecast forecast : weather.getDaily_forecast()) {
                View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
                TextView dateText = view.findViewById(R.id.date_text);
                TextView infoText = view.findViewById(R.id.info_text);
                TextView maxText = view.findViewById(R.id.max_text);
                TextView minText = view.findViewById(R.id.min_text);

                dateText.setText(forecast.getDate());
                infoText.setText(forecast.getCondTxtD());
                maxText.setText(forecast.getTmpMax());
                minText.setText(forecast.getTmpMin());
                forecastLayout.addView(view);
            }
            List<Lifestyle> lifestyleList = weather.getLifestyle();
            String comfort = null;
            String uv = null;
            String sport = null;
            String carWash = null;
            for (Lifestyle l : lifestyleList) {
                switch (l.getType()) {
                    case "comf":
                        comfort = "舒适度： " + l.getTxt();
                        break;
                    case "uv":
                        uv = "紫外线： " + l.getTxt();
                        break;
                    case "sport":
                        sport = "运动建议： " + l.getTxt();
                        break;
                    case "cw":
                        carWash = "洗车建议： " + l.getTxt();
                        break;
                    default:
                        break;
                }
            }
            comfortText.setText(comfort);
            uvText.setText(uv);
            sportText.setText(sport);
            washText.setText(carWash);
            scrollLayout.setVisibility(View.VISIBLE);

            // 开启后台自动更新服务
            Intent intent = new Intent(this, AutoUpdateService.class);
            startService(intent);
        } else {
            Toast.makeText(this, "获取失败", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.nav_button)
    public void onViewClicked() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}
