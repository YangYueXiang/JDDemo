package com.bwie.presenter;

import com.bwie.view.IView.BaseView;

/**
 * Created by YangYueXiang
 * on 2018/10/13
 */
public class BasePresenter <V extends BaseView>{

    private V iv;
    public void attachView(V v){
        this.iv=v;
    }
    public void detachView(){
        this.iv=null;
    }
    public V getView(){
        return iv;
    }

}
