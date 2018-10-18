package com.bwie.model.IModel;

import com.bwie.model.bean.HomeBean;
import com.bwie.model.net.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class HomeModel {
    public void homeShangModel(final HomeShangCallBack homeShangCallBack){
        Observable<HomeBean> homeShangData = HttpUtils.httpUtilsInstance().api.getHomeData();
        homeShangData
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBean homeBean) {
                HomeBean.DataBean data = homeBean.getData();
                homeShangCallBack.homeshangcallback(data);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public interface HomeShangCallBack{
        void homeshangcallback(HomeBean.DataBean data);
    }
}
