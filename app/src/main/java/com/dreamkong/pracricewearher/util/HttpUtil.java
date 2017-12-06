package com.dreamkong.pracricewearher.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * @author bsbj
 * @date 2017/12/5.
 */

public class HttpUtil {

    public static void sendOkhttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
