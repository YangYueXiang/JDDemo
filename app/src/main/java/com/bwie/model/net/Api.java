package com.bwie.model.net;

import com.bwie.model.bean.FenLeftBean;
import com.bwie.model.bean.FenRightBean;
import com.bwie.model.bean.HomeBean;
import com.bwie.model.bean.HomeLunBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public interface Api {
    @GET("product/getCatagory")
    Observable<FenLeftBean> getData();
    @GET("product/getProductCatagory")
    Observable<FenRightBean> getRightData(@Query("cid") String cid);
    @GET("ad/getAd")
    Observable<HomeLunBean> getLunData();
    @GET("home/getHome")
    Observable<HomeBean> getHomeData();
}
