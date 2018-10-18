package com.bwie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.jddemo.R;
import com.bwie.model.bean.FenLeftBean;
import com.bwie.model.bean.FenRightBean;
import com.bwie.presenter.FenLeftPresenter;
import com.bwie.presenter.FenRightPresenter;
import com.bwie.view.IView.FenLeiView;
import com.bwie.view.adapter.FenLeftAdapter;
import com.bwie.view.adapter.FenRightAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class FenleiFragment extends Fragment implements FenLeiView {

    @BindView(R.id.recycler_left)
    RecyclerView recyclerLeft;
    @BindView(R.id.recycler_right)
    RecyclerView recyclerRight;
    Unbinder unbinder;
    private FenLeftPresenter fenLeftPresenter;
    private FenRightPresenter fenRightPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fenlei, container, false);
        fenLeftPresenter = new FenLeftPresenter();
        fenRightPresenter = new FenRightPresenter();
        fenLeftPresenter.attachView(this);
        fenRightPresenter.attachView(this);
        fenLeftPresenter.getDataFromNet();

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void leftSuccess(final List<FenLeftBean.DataBean> msg) {
        //Toast.makeText(getActivity(), "msg:" + msg, Toast.LENGTH_SHORT).show();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerLeft.setLayoutManager(manager);
        FenLeftAdapter fenLeftAdapter = new FenLeftAdapter(getActivity(), msg);
        recyclerLeft.setAdapter(fenLeftAdapter);

        fenLeftAdapter.setOnItemClickListener(new FenLeftAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Toast.makeText(getActivity(), "点击了"+position, Toast.LENGTH_SHORT).show();
                fenRightPresenter.getDataRight(String.valueOf(msg.get(position).getCid()));
            }
        });
    }

    @Override
    public void rightSuccess(List<FenRightBean.DataBean> msg) {
       // Toast.makeText(getActivity(), "msg:" + msg, Toast.LENGTH_SHORT).show();
       // Log.i("www",msg.toString());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerRight.setLayoutManager(manager);
        FenRightAdapter myRightAdapter = new FenRightAdapter(getActivity(), msg);
        recyclerRight.setAdapter(myRightAdapter);
    }

    @Override
    public void error(int errCode, String errmsg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fenLeftPresenter.detachView();
        fenRightPresenter.detachView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
