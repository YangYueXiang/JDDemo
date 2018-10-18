package com.bwie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.jddemo.R;
import com.bwie.model.bean.FenRightBean;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class FenRightAdapter extends RecyclerView.Adapter<FenRightAdapter.twoholder> {
    private Context context;
    private List<FenRightBean.DataBean> list;

    public FenRightAdapter(Context context, List<FenRightBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public twoholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenright_one, parent, false);
        twoholder twoholder = new twoholder(view);
        return twoholder;
    }

    @Override
    public void onBindViewHolder(@NonNull twoholder holder, int position) {
        holder.tv_rightTitle.setText(list.get(position).getName());
        holder.recycler_rightview.setLayoutManager(new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false));
        FenRightInAdapter fenRightInAdapter = new FenRightInAdapter(context,list.get(position).getList());
        holder.recycler_rightview.setAdapter(fenRightInAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class twoholder extends RecyclerView.ViewHolder {

        private final TextView tv_rightTitle;
        private final RecyclerView recycler_rightview;

        public twoholder(View itemView) {
            super(itemView);
            tv_rightTitle = itemView.findViewById(R.id.tv_rightTitle);
            recycler_rightview = itemView.findViewById(R.id.recycler_rightview);
        }
    }
}
