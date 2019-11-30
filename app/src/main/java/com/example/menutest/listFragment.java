package com.example.menutest;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class listFragment extends Fragment {

    public listFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        String [] menuItems = new String[] {"test"};

        String msg_enviado = (dataController.enviar(620, 621, "Esto es una prueba")) ? "Enviado":"Error";

        ArrayList<Persona> base = dataController.alumnosProfesor(dataController.getUser(),1);

        String str[] = new String[base.size()];

        for (int i = 0; i < base.size(); i++) {
            str[i] = base.get(i).id + " " + base.get(i).nombre + " " + base.get(i).primer_apellido + " " + base.get(i).segundo_apellido;
        }


        //String a = String.format("%5d%12s%14=s%14s", base.get(i).id,
                //base.get(i).nombre, base.get(i).primer_apellido, base.get(i).segundo_apellido);
        menuItems = str;


        //dataController.listado(true, 1).get(0).correo};
        //dataController.alumnosProfesor(620, 1).get(0).primer_apellido};
        //dataController.persona(true, 2000).correo};
        //dataController.persona(false, 620).correo};
        //msg_enviado};
        //dataController.buzon(617, 1).get(0).contenido};
        //String.valueOf(dataController.grupoAlumno(620).alumnos)};
        //dataController.buzon(617, 1).get(1).contenido};




        ListView listView = (ListView) view.findViewById(R.id.mainListMenu);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }
}
