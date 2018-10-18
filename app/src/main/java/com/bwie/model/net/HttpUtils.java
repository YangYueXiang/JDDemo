package com.bwie.model.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class HttpUtils {

    public final   Api api;
    //内部类实现单例
    private static class HttpUtilsInstance{
        private static HttpUtils httpUtils=new HttpUtils();
    }

    public static HttpUtils httpUtilsInstance(){
        return HttpUtilsInstance.httpUtils;
    }


    private HttpUtils(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Lan())
                .build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);

    }

    class Lan implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            String method = request.method();
            Log.i("aaa",method);
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }


}
