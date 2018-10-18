package com.bwie.model.IModel;

import com.bwie.model.bean.HomeLunBean;
import com.bwie.model.net.HttpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class HomeLunModel {
    public void homeLunModel(final HomeLunCallBack homeLunCallBack){
        Observable<HomeLunBean> lunData = HttpUtils.httpUtilsInstance().api.getLunData();
        lunData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<HomeLunBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeLunBean homeLunBean) {
                List<HomeLunBean.DataBean> data = homeLunBean.getData();
                homeLunCallBack.callBack(data);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface HomeLunCallBack{
        void callBack(List<HomeLunBean.DataBean> data);
    }
}
