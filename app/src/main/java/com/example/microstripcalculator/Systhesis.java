package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Systhesis extends AppCompatActivity {

    EditText impedence;
    EditText dielectric;
    EditText height_ed;
    String imp,dil,height;

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

        imp = impedence.getText().toString();
        dil = dielectric.getText().toString();
        height = height_ed.getText().toString();

        if (imp.matches("") || dil.matches("") || height.matches("")) {
            Toast.makeText(this, "Enter the given values", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent synthesis_result_calc = new Intent(this,SysthesisResults.class);

        synthesis_result_calc.putExtra("impedence",imp);
        synthesis_result_calc.putExtra("dielectric",dil);
        synthesis_result_calc.putExtra("height",height);

        startActivity(synthesis_result_calc);
    }



}
