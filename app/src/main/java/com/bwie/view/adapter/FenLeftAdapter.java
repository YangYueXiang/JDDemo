package com.bwie.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.jddemo.R;
import com.bwie.model.bean.FenLeftBean;

import java.util.List;

/**
 * Created by YangYueXiang
 * on 2018/10/12
 */
public class FenLeftAdapter extends RecyclerView.Adapter<FenLeftAdapter.oneholder> {
    private Context context;
    private List<FenLeftBean.DataBean> list;
    private OnItemClickListener onItemClickListener;

    public FenLeftAdapter(Context context, List<FenLeftBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public oneholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fenleft, parent, false);
        oneholder oneholder = new oneholder(view);
        return oneholder;
    }

    @Override
    public void onBindViewHolder(@NonNull final oneholder holder, final int position) {
        holder.fenleft.setText(list.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public  class oneholder extends RecyclerView.ViewHolder{

        private final TextView fenleft;

        public oneholder(View itemView) {
            super(itemView);
            fenleft = itemView.findViewById(R.id.fenleft);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
