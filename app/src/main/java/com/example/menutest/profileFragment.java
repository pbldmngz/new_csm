package com.example.menutest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class profileFragment extends Fragment {

    TextView numberGroups, profilePhone, profileEmail, tv_name, tv_lastname, tv_title, nGroups, nStudents;

    public profileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        numberGroups = (TextView) view.findViewById(R.id.numberGroups);
        profilePhone = (TextView) view.findViewById(R.id.profilePhone);
        profileEmail = (TextView) view.findViewById(R.id.profileEmail);
        tv_name = (TextView) view.findViewById(R.id.tv_name);
        tv_title = (TextView) view.findViewById(R.id.tv_title);
//        nGroups = view.findViewById(R.id.numberGroups);
//        nStudents = view.findViewById(R.id.numberStudents);

        Persona p = dataController.persona(false, dataController.getUser());
        grupoAlumno gp = dataController.grupoAlumno(dataController.getUser());

        profilePhone.setText(telGen(p.tel_grupo));
        profileEmail.setText(p.correo);
        tv_name.setText(p.nombre + " " + p.primer_apellido);
        tv_title.setText(String.valueOf(p.id));
//        nGroups.setText(String.valueOf(gp.grupos));
//        nStudents.setText(String.valueOf(gp.alumnos));

        return view;
    }
    private String telGen(String base){
        return "(" + base.substring(0,3) + ") " + base.substring(3,7) + "-" + base.substring(7,10);
    }
}
