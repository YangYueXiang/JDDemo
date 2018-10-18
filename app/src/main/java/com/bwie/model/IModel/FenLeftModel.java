package com.bwie.model.IModel;


import com.bwie.model.bean.FenLeftBean;
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
public class FenLeftModel {

    public void LeftModel(final MyLeftCallBak myLeftCallBak){
           Observable<FenLeftBean> data = HttpUtils.httpUtilsInstance().api.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenLeftBean>() {

                    @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(FenLeftBean fenLeftBean) {
                List<FenLeftBean.DataBean> data1;
                data1 = fenLeftBean.getData();
                myLeftCallBak.onSuccess(data1);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

   public interface  MyLeftCallBak{
        void onSuccess(List<FenLeftBean.DataBean> data);
    }
}
