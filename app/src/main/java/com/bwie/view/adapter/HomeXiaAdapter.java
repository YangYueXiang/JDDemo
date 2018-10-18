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
 * on 2018/10/18
 */
public class HomeXiaAdapter extends RecyclerView.Adapter<HomeXiaAdapter.homexiaholder> {
    private Context context;
    private  List<HomeBean.DataBean.TuijianBean.ListBeanX> list;

    public HomeXiaAdapter(Context context, List<HomeBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public homexiaholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_xia, parent, false);
        homexiaholder homexiaholder = new homexiaholder(view);
        return homexiaholder;
    }

    @Override
    public void onBindViewHolder(@NonNull homexiaholder holder, int position) {
        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.simp_homexia.setImageURI(uri);
        holder.tv_homexia.setText(list.get(position).getTitle());
        holder.tv_homeprice.setText("$"+list.get(position).getBargainPrice()+".00");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class homexiaholder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simp_homexia;
        private final TextView tv_homexia;
        private final TextView tv_homeprice;

        public homexiaholder(View itemView) {
            super(itemView);
            simp_homexia = itemView.findViewById(R.id.simp_homexia);
            tv_homexia = itemView.findViewById(R.id.tv_homexianame);
            tv_homeprice = itemView.findViewById(R.id.tv_homexiaprice);
        }
    }
}
