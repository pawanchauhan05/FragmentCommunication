package com.pawan.fragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("demo1", "demo1 description"));
        itemList.add(new Item("demo2", "demo2 description"));
        itemList.add(new Item("demo3", "demo3 description"));
        itemList.add(new Item("demo4", "demo4 description"));
        itemList.add(new Item("demo5", "demo5 description"));
        recyclerAdapter = new RecyclerAdapter(itemList, this, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

}
