package com.example.shvyryaev_lab2;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



import androidx.annotation.Nullable;

import com.example.shvyryaev_lab2.ui.login.LoginActivity;


public class Frag_interface extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public Frag_interface() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_interface, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btn = (Button) view.findViewById(R.id.callback_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback!= null)
                    callback.callingBack();
            }
        });
    }
    @Override
    public void onClick(View view) {

    }

    public interface Callback{
        void callingBack();
    }

    private Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callback = (Callback) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement Callback");
        }
    }






}