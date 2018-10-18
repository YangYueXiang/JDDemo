package com.bwie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.jddemo.R;
import com.bwie.model.bean.HomeBean;
import com.bwie.model.bean.HomeLunBean;
import com.bwie.presenter.HomeLunPresenter;
import com.bwie.presenter.HomePresenter;
import com.bwie.view.IView.HomeView;
import com.bwie.view.adapter.HomeShangAdapter;
import com.bwie.view.adapter.HomeXiaAdapter;
import com.recker.flybanner.FlyBanner;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class HomeFragment extends Fragment implements HomeView {

    private FlyBanner fly_banner;
    private List<String>  list=new ArrayList<>();
    private HomeLunPresenter homeLunPresenter;
    private RecyclerView recycler_home_shang;
    private HomePresenter homePresenter;
    private MarqueeView marqueeView;
    private RecyclerView recycler_home_xia;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container,false);
        fly_banner = view.findViewById(R.id.fly_banner);
        marqueeView = view.findViewById(R.id.marqueeView);
        recycler_home_shang = view.findViewById(R.id.recycler_home_shang);
        recycler_home_xia = view.findViewById(R.id.recycler_home_xia);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeLunPresenter = new HomeLunPresenter();
        homeLunPresenter.attachView(this);
        homeLunPresenter.getLunData();
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.getDataHomeShang();



        List<String> info = new ArrayList<>();
        info.add("欢迎访问京东app");
        info.add("大家有没有在 听课");
        info.add("是不是还有人在睡觉");
        info.add("你妈妈在旁边看着呢");
        info.add("赶紧的好好学习吧 马上毕业了");
        info.add("你没有事件睡觉了");
        marqueeView.startWithList(info);
    }

    @Override
    public void lunsuccess(List<HomeLunBean.DataBean> data) {
        for (HomeLunBean.DataBean datum : data) {
            String icon = datum.getIcon();
            list.add(icon);
        }
        fly_banner.setImagesUrl(list);
    }

    @Override
    public void shangsuccess(HomeBean.DataBean list) {
       // Toast.makeText(getActivity(), "fenlei:" + list, Toast.LENGTH_SHORT).show();
        //九宫格
        recycler_home_shang.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.HORIZONTAL,false));
        HomeShangAdapter homeShangAdapter = new HomeShangAdapter(getActivity(), list.getFenlei());
        recycler_home_shang.setAdapter(homeShangAdapter);
        //推荐
        recycler_home_xia.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
        HomeXiaAdapter homeXiaAdapter = new HomeXiaAdapter(getActivity(),list.getTuijian().getList());
        recycler_home_xia.setAdapter(homeXiaAdapter);
    }

    @Override
    public void lunerror() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeLunPresenter.detachView();
        homePresenter.detachView();
    }
}
