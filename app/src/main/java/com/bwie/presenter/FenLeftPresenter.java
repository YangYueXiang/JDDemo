package com.bwie.presenter;

import android.util.Log;

import com.bwie.model.IModel.FenLeftModel;
import com.bwie.model.bean.FenLeftBean;
import com.bwie.view.IView.FenLeiView;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class FenLeftPresenter  extends BasePresenter<FenLeiView>{

    private final FenLeftModel mainModel;

    public FenLeftPresenter(){
        mainModel = new FenLeftModel();
    }

    public void getDataFromNet(){
        mainModel.LeftModel(new FenLeftModel.MyLeftCallBak() {
            @Override
            public void onSuccess(List<FenLeftBean.DataBean> data) {
                Log.i("presenter",data+"");
                getView().leftSuccess(data);
            }
        });
        }
}
