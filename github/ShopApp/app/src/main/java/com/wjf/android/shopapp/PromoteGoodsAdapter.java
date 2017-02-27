package com.wjf.android.shopapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by ad06-wjf on 2017/1/10.
 */

public class PromoteGoodsAdapter extends RecyclerView.Adapter <PromoteGoodsAdapter.ViewHolder>{

    private List<String> mlist;
    private Context context;

    public void setMlist(List<String> mlist) {
        this.mlist = mlist;
    }

    public PromoteGoodsAdapter(List<String> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_promote_goods);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.promote_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String str = mlist.get(position);
        Glide.with(context).load(str).into(holder.imageView);
        Log.d(">>>>>", "onBindViewHolder: " + str);
    }



    @Override
    public int getItemCount() {
        return mlist.size();
    }
}