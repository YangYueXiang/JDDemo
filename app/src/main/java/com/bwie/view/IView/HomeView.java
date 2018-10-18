package com.bwie.view.IView;

import com.bwie.model.bean.HomeBean;
import com.bwie.model.bean.HomeLunBean;
import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public interface HomeView extends BaseView{
    void lunsuccess(List<HomeLunBean.DataBean> data);
    void shangsuccess(HomeBean.DataBean fenlei);
    void lunerror();
}
