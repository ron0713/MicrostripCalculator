package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.*;

public class SysthesisResults extends AppCompatActivity {

    String imp,dil,height;

    double a,zc,er,wh,b,h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systhesis_results);

        Intent synthesis_retrieval = getIntent();
        imp = synthesis_retrieval.getExtras().getString("impedence");
        dil = synthesis_retrieval.getExtras().getString("dielectric");
        height = synthesis_retrieval.getExtras().getString("height");
        zc = Double.valueOf(imp);
        er = Double.valueOf(dil);
        h = Double.valueOf(height);

        a = (zc/60) * java.lang.Math.pow((er+1)/2,0.5)  + ((er-1)/(er+1))*(0.23+(0.11/er));

        wh = (Math.exp(a)*8)/(Math.exp(2*a)-1);

        if(wh > 2){
            b = (60*Math.PI*Math.PI)/zc*Math.pow(er,0.5);
            wh = (2/Math.PI) * ( (b-1) - Math.log(2*b-1) + ((er-1)/2*er) * (Math.log(b-1) + 0.39 - (0.61/er) ) );
        }

        wh = wh*h;

    }

    public void show_result(View view){

        Intent final_result_synthesis = new Intent(this,SysthesisResultsFinal.class);
        final_result_synthesis.putExtra("final_result",wh);

        startActivity(final_result_synthesis);
    }
}
