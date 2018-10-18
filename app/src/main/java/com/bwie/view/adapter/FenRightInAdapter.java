package com.bwie.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.jddemo.R;
import com.bwie.model.bean.FenRightBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/17
 */
class FenRightInAdapter extends RecyclerView.Adapter<FenRightInAdapter.threeholder> {
    private Context context;
    private List<FenRightBean.DataBean.ListBean> list;

    public FenRightInAdapter(Context context, List<FenRightBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public threeholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenright_in, parent, false);
        threeholder threeholder = new threeholder(view);
        return threeholder;
    }

    @Override
    public void onBindViewHolder(@NonNull threeholder holder, int position) {
        Uri uri = Uri.parse(list.get(position).getIcon());
        holder.simp_fenin.setImageURI(uri);
        holder.tv_fenin.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class threeholder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simp_fenin;
        private final TextView tv_fenin;

        public threeholder(View itemView) {
            super(itemView);
            simp_fenin = itemView.findViewById(R.id.simp_fenin);
            tv_fenin = itemView.findViewById(R.id.tv_fenintitle);
        }
    }
}
