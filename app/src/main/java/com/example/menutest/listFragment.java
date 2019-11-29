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

public class listFragment extends Fragment {

    TextView display;

    public listFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //Ejemplo de uso del validLogin, devuelve true/false, te lo dejo a ti

        //String valid = (dataController.validLogin("Araceli.Cabrera.625@cetys.mx","treeeee")) ? "valido":"no existe";
        String [] menuItems = new String[0];

        String msg_enviado = (dataController.enviar(620, 621, "Esto es una prueba")) ? "Enviado":"Error";

        //Lo que se obtine de los metodos con listado son listas de JSONObject, usa estos atributos como ejemplo
        // Cuando los uses puedes guardar el JsonObject en una variable para no tener que llamar el método a cada vez


        menuItems = new String[]{"a","b","c","d",//, valid,
                //dataController.listado(true, 1).get(0).correo};
                //dataController.alumnosProfesor(620, 1).get(0).primer_apellido};
                //dataController.persona(true, 2000).correo};
                //dataController.persona(false, 620).correo};
                //msg_enviado};
                dataController.buzon(617, 1).get(0).contenido};
                //dataController.buzon(617, 1).get(1).contenido};
                //};


        ListView listView = (ListView) view.findViewById(R.id.mainListMenu);

        display = (TextView) view.findViewById(R.id.displayJson);

        //Necesitamos poder poner de forma ordenada los datos, como en columnas

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );

        listView.setAdapter(listViewAdapter);



        return view;
    }



}
