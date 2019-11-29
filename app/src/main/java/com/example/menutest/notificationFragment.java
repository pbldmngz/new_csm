package com.example.menutest;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class notificationFragment extends Fragment {

    ListView listNotifications;

    public notificationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_notification, container, false);

       listNotifications = (ListView) view.findViewById(R.id.listNotifications);

        String [] menuItems;


        menuItems = new String[]{dataController.buzon(620, 1).get(0).contenido};

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listNotifications.setAdapter(listViewAdapter);

        return view;
    }
}
