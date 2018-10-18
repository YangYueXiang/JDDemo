package com.bwie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.jddemo.R;
import com.bwie.model.bean.HomeBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
public class HomeShangAdapter extends RecyclerView.Adapter<HomeShangAdapter.homeshangholder> {

    private Context context;
    private List<HomeBean.DataBean.FenleiBean> list;

    public HomeShangAdapter(Context context, List<HomeBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public homeshangholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_shang, parent, false);
        homeshangholder homeshangholder = new homeshangholder(view);
        return homeshangholder;
    }

    @Override
    public void onBindViewHolder(@NonNull homeshangholder holder, int position) {
        holder.tv_homeshang.setText(list.get(position).getName());
        Uri uri = Uri.parse(list.get(position).getIcon());
        holder.simp_homeshang.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class homeshangholder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simp_homeshang;
        private final TextView tv_homeshang;

        public homeshangholder(View itemView) {
           super(itemView);
            simp_homeshang = itemView.findViewById(R.id.simp_homeshang);
            tv_homeshang = itemView.findViewById(R.id.tv_homeshang);

        }
   }
}
