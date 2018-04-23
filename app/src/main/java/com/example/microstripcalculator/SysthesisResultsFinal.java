package com.example.microstripcalculator;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SysthesisResultsFinal extends AppCompatActivity {

    double result;
    EditText result_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systhesis_results_final);

        Intent result_value_systhesis = getIntent();

        result = result_value_systhesis.getExtras().getDouble("final_result");

        result_view = (EditText) findViewById(R.id.editText9);

        result_view.setText(Double.toString(result));
    }

    public void back_home(View view){
        Intent main_activity = new Intent(this,MainScreen.class);

        startActivity(main_activity);
    }
}
