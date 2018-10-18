package com.bwie.view.IView;

import com.bwie.model.bean.FenLeftBean;
import com.bwie.model.bean.FenRightBean;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/13
 */
public interface FenLeiView extends BaseView{
    void leftSuccess(List<FenLeftBean.DataBean> msg);
    void rightSuccess(List<FenRightBean.DataBean> msg);
    void error(int errCode,String errmsg);

}
