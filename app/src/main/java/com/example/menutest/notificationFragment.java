package com.example.menutest;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

public class notificationFragment extends Fragment {
    View v;

    public notificationFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_notification, container, false);
        return v;
//        Notification.Campat.Builder builder =new Notification.Campat.Builder(this);
//        builder.setContentTitle("correo del emisor")
//                String text = "mesaje que envio";
//        builder.setContentText(text);
//        PendingIntent contentintent=new PendingIntent(this);
//        builder.setContentIntent(contentintent);
//        Notification notification=builder.build();
//        NotificationManagerCompat.from(this).notify(0,notification);
    }
}
