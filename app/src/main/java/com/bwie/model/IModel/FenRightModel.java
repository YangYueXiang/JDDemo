package com.bwie.model.IModel;

import android.util.Log;

import com.bwie.model.bean.FenLeftBean;
import com.bwie.model.bean.FenRightBean;
import com.bwie.model.net.HttpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class FenRightModel {
    public void RightModel(String cid, final MyRightCallBak myRightCallBak){
        Log.i("wowowo",cid+"");
        Observable<FenRightBean> data = HttpUtils.httpUtilsInstance().api.getRightData(cid);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenRightBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenRightBean fenRightBean) {
                        List<FenRightBean.DataBean> data1 = fenRightBean.getData();
                        myRightCallBak.onSuccess(data1);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface  MyRightCallBak{
        void onSuccess(List<FenRightBean.DataBean> data1);
    }


}
