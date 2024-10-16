package com.example.lab5_java;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.lab5_java.databinding.FragmentNotificationsBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    FirebaseFirestore firestore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button button = binding.button3;

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyPushNotification myPushNotification = new MyPushNotification(view.getContext().getApplicationContext(), requireActivity().getSystemService(NotificationManager.class));
                myPushNotification.sendNotify("День","Скоро конец рабочего дня");

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}