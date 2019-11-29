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

    TextView numberGroups, profilePhone;

    public profileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        numberGroups = (TextView) view.findViewById(R.id.numberGroups);
        profilePhone = (TextView) view.findViewById(R.id.profilePhone);

        profilePhone.setText(telGen(dataController.persona(false, 620).tel_grupo));

        return view;
    }
    private String telGen(String base){
        return "(" + base.substring(0,3) + ") " + base.substring(3,7) + "-" + base.substring(7,10);
    }
}
