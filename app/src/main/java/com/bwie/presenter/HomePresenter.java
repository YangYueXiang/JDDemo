package com.bwie.presenter;
import com.bwie.model.IModel.HomeModel;
import com.bwie.model.bean.HomeBean;
import com.bwie.view.IView.HomeView;


/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class HomePresenter extends BasePresenter<HomeView> {

    private final HomeModel homeShangModel;

    public HomePresenter(){
        homeShangModel = new HomeModel();
    }
    public void getDataHomeShang(){
        homeShangModel.homeShangModel(new HomeModel.HomeShangCallBack() {
            @Override
            public void homeshangcallback(HomeBean.DataBean data) {
                getView().shangsuccess(data);
            }
        });
    }
}
