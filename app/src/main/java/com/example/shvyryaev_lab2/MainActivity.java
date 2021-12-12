package com.example.shvyryaev_lab2;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements Frag_interface.Callback {
    Fragment1 frag1;
    Fragment2 frag2;
    Frag_interface frag3;
    TextView txt1;
    FragmentTransaction fTrans;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();
        frag3 = new Frag_interface();
        txt1 = (TextView) findViewById(R.id.textView);


    }



    public void onClick(View view) {
        fTrans = getFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btnAct2:
                fTrans.add(R.id.frgmCont, frag1);
                break;
            case R.id.btnMenu:
                fTrans.add(R.id.frgmCont, frag3);
                break;
            case R.id.btnAct3:
                fTrans.replace(R.id.frgmCont, frag2);
            default:
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
    }



    @Override
    public void callingBack() {
        txt1.setText("Коллбэк получен");
    }
}