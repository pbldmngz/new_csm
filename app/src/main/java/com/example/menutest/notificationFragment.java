package com.example.menutest;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class notificationFragment extends Fragment {

    Button writeMessage;

    ListView listNotifications;

    public notificationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);

       listNotifications = (ListView) view.findViewById(R.id.listNotifications);
       writeMessage = (Button) view.findViewById(R.id.writeMessage);

        String [] menuItems;
        ArrayList<Mensaje> base = dataController.buzon(dataController.getUser(), 1);

        String str[] = new String[base.size()];

        for (int i = 0; i < base.size(); i++) {
            str[i] = base.get(i).contenido;
        }

        menuItems = str;

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listNotifications.setAdapter(listViewAdapter);

        writeMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), sendMessageClass.class);
                startActivity(i);
            }
        });

        return view;
    }
}
