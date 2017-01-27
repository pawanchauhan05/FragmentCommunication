package com.pawan.fragmentcommunication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pawan on 27/1/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Item> itemList;
    private Fragment fragment;
    private LayoutInflater inflater;

    public interface ItemClickListener {
        void onClick(View view, int position, boolean isLongClick);
    }

    public RecyclerAdapter(List<Item> itemList, Fragment fragment, Context context) {
        this.itemList = itemList;
        this.fragment = fragment;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View customRow = inflater.inflate(R.layout.adapter_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(customRow);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(itemList.get(position).getName());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if(fragment instanceof FirstFragment) {
                    MainActivity activity = (MainActivity) ((FirstFragment)fragment).getActivity();
                    activity.getDataTransferHelper().setText(itemList.get(position).getDescription());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        private ItemClickListener clickListener;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        public void setClickListener(ItemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getLayoutPosition(), false);
        }
    }
}
