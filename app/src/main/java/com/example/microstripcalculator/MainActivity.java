package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void synthesis(View view){
        Intent synthesis_calculation = new Intent(this,Systhesis.class);
        startActivity(synthesis_calculation);
    }

    public void analysis(View view){
        Intent analysis_calculation = new Intent(this,Analysis.class);
        startActivity(analysis_calculation);
    }


}
