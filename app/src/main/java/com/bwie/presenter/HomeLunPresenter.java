package com.bwie.presenter;

import com.bwie.model.IModel.HomeLunModel;
import com.bwie.model.bean.HomeLunBean;
import com.bwie.view.IView.HomeView;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class HomeLunPresenter extends BasePresenter<HomeView> {

    private final HomeLunModel homeLunModel;

    public HomeLunPresenter(){
        homeLunModel = new HomeLunModel();
    }

    public void getLunData(){
        homeLunModel.homeLunModel(new HomeLunModel.HomeLunCallBack() {
            @Override
            public void callBack(List<HomeLunBean.DataBean> data) {
                getView().lunsuccess(data);
            }
        });
    }



}
