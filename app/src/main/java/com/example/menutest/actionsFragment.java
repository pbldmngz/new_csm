package com.example.menutest;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;

import java.nio.charset.Charset;
import java.util.Calendar;

public class actionsFragment extends Fragment {

    EditText year = null;
    Spinner month = null;
    EditText day = null;
    CheckBox duration = null;
    Spinner hour = null;
    EditText minute = null;
    Button add = null;
    EditText title = null;
    EditText description = null;
    EditText location = null;



    public actionsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actions, container, false);

        year = (EditText) view.findViewById(R.id.etAño);
        month = (Spinner) view.findViewById(R.id.spMes);
        day = (EditText) view.findViewById(R.id.etDia);
        duration = (CheckBox) view.findViewById(R.id.chkDuracion);
        hour = (Spinner) view.findViewById(R.id.spHora);
        minute = (EditText) view.findViewById(R.id.etMinuto);
        add = (Button) view.findViewById(R.id.btnAnadir);
        title = (EditText) view.findViewById(R.id.etTitulo);
        description = (EditText) view.findViewById(R.id.etDescripcion);
        location = (EditText) view.findViewById(R.id.etLocation);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
            }
        });

        ArrayAdapter<CharSequence> adapmes = ArrayAdapter.createFromResource(getActivity(), R.array.meses, android.R.layout.simple_spinner_item);
        month.setAdapter(adapmes);

        ArrayAdapter<CharSequence> adaphora = ArrayAdapter.createFromResource(getActivity(), R.array.horas, android.R.layout.simple_spinner_item);
        hour.setAdapter(adaphora);

        return view;
    }

    public void Add() {
        Calendar cal = Calendar.getInstance();

        boolean val = false;
        Intent intent = null;

        while (val == false) {
            try {
                cal.set(Calendar.YEAR, Integer.parseInt(year.getText().toString()));
                cal.set(Calendar.MONTH, (Integer.parseInt(month.getSelectedItem().toString()) - 1));
                cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day.getText().toString()));

                cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt((hour.getSelectedItem().toString())));// Set de HORA y MINUTO
                cal.set(Calendar.MINUTE, Integer.parseInt(minute.getText().toString()));            //

                intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");

                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, cal.getTimeInMillis());
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, cal.getTimeInMillis() + 60 * 60 * 1000);

                intent.putExtra(CalendarContract.Events.ALL_DAY, duration.isSelected());
                intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());

                startActivity(intent);
                val = true;
            } catch (Exception e) {
                year.setText("");
                day.setText("");
                Toast.makeText(getActivity().getApplicationContext(), "Fecha Inválida", Toast.LENGTH_LONG).show();
            }
        }
    }
}
