package com.example.menutest;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class notificationFragment extends Fragment {

    ListView listNotifications;

    public notificationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_notification, container, false);

       listNotifications = (ListView) view.findViewById(R.id.listNotifications);

        return view;
    }
}
