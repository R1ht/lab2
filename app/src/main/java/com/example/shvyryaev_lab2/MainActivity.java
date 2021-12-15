package com.example.shvyryaev_lab2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shvyryaev_lab2.ui.login.LoginActivity;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

public class MainActivity extends Activity implements Frag_interface.Callback {
    TextView txt1;
    FragmentTransaction fTrans;
    private Bus bus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.textView);
        bus = new Bus();
        bus.register(this);
    }



    public void onClick(View view) {
        fTrans = getFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btnAct2:
                fTrans.replace(R.id.frgmCont, new Fragment1());
                break;
            case R.id.btnMenu:

                fTrans.replace(R.id.frgmCont, new Frag_interface());
                break;
            case R.id.btnAct3:
                fTrans.replace(R.id.frgmCont, new Fragment2());
                break;

            case R.id.logActButton:
                bus.post(new Activator());
                break;

            default:
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

    @Subscribe
    public void ActivityStarter(Activator event){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    @Override
    public void callingBack() {
        txt1.setText("Коллбэк получен");
    }
}