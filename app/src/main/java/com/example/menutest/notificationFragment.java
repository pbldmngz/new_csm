package com.example.menutest;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class notificationFragment extends Fragment {

    ListView listNotifications;

    EditText id_emisor, id_receptor, message;

    public notificationFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);

       listNotifications = (ListView) view.findViewById(R.id.listNotifications);

       id_emisor = (EditText) view.findViewById(R.id.id_emisor);
       id_receptor = (EditText) view.findViewById(R.id.id_receptor);
       message = (EditText) view.findViewById(R.id.messageNotifications);

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

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.optionsMenu) {

        }

        return super.onOptionsItemSelected(item);
    }
}
