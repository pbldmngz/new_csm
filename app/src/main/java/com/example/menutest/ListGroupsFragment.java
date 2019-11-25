package com.example.menutest;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListGroupsFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<Group> lstGroup;

    public ListGroupsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_groups, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.groupsRecyclerView);
        RecyclerViewAdapter recyclerAdapter = new RecyclerViewAdapter(getContext(), lstGroup);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstGroup = new ArrayList<>();
        lstGroup.add(new Group("IS", 2, R.drawable.iconis));
        lstGroup.add(new Group("IDGD", 1, R.drawable.iconidgd));

    }
}
