package com.bwie.presenter;
import com.bwie.model.IModel.FenRightModel;
import com.bwie.model.bean.FenRightBean;
import com.bwie.view.IView.FenLeiView;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class FenRightPresenter extends BasePresenter<FenLeiView>{


    private final FenRightModel fenRightModel;

    public FenRightPresenter(){
        fenRightModel = new FenRightModel();
    }
    public void getDataRight(String cid) {
        fenRightModel.RightModel(cid, new FenRightModel.MyRightCallBak() {
            @Override
            public void onSuccess(List<FenRightBean.DataBean> data1) {
                getView().rightSuccess(data1);
            }
        });
    }
}
