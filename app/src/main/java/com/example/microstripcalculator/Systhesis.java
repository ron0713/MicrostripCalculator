package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Systhesis extends AppCompatActivity {

    EditText impedence;
    EditText dielectric;
    EditText height_ed;
    Double imp,dil,height;
    Double a,zc,er,wh,b,h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systhesis);
        Intent main_intent = getIntent();

    }

    public void synthesis_calc(View view){
        impedence = (EditText) findViewById(R.id.editText4);
        dielectric = (EditText) findViewById(R.id.editText8);
        height_ed = (EditText) findViewById(R.id.editText20);

        imp = Double.valueOf(impedence.getText().toString());
        dil = Double.valueOf(dielectric.getText().toString());
        height = Double.valueOf(height_ed.getText().toString());
        er = dil;
        zc = imp;
        h = height;
        if (impedence.getText().toString().matches("") || impedence.getText().toString().matches("") || height_ed.getText().toString().matches("")) {
            Toast.makeText(this, "Enter the given values", Toast.LENGTH_SHORT).show();
            return;
        }

        a = (zc/60) * java.lang.Math.pow((er+1)/2,0.5)  + ((er-1)/(er+1))*(0.23+(0.11/er));

        wh = (Math.exp(a)*8)/(Math.exp(2*a)-2);

        if(wh >= 2){
            b = (60*Math.PI*Math.PI)/zc*Math.pow(er,0.5);
            wh = (2/Math.PI) * ( (b-1) - Math.log(2*b-1) + ((er-1)/2*er) * (Math.log(b-1) + 0.39 - (0.61/er) ) );
        }

        wh = wh*h;
        Log.i("zc",wh.toString());
        Intent final_result_synthesis = new Intent(this,SysthesisResultsFinal.class);
        final_result_synthesis.putExtra("final_result",wh);

        startActivity(final_result_synthesis);
    }



}
