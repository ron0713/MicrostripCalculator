package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisThickness extends AppCompatActivity {

    EditText zct_result, eret_result;

    Double zc,ere,ere_f,zc_f,ere_t,zc_t,loss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_thickness);

        Intent values = getIntent();

        zc =values.getExtras().getDouble("zc");
        ere = values.getExtras().getDouble("ere");
        zc_t = values.getExtras().getDouble("zc_t");
        ere_t =values.getExtras().getDouble("ere_t");
        ere_f = values.getExtras().getDouble("ere_f");
        zc_f = values.getExtras().getDouble("zc_f");
        loss = values.getExtras().getDouble("loss");



        zct_result = (EditText)findViewById(R.id.editText14);
        eret_result = (EditText)findViewById(R.id.editText13);

        zct_result.setText(Double.toString(zc_t));
        eret_result.setText(Double.toString(ere_t));
    }

    public void back_home_main(View view){
        Intent analysis_result_calc = new Intent(this,AnswerScreen.class);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("ere",ere);
        analysis_result_calc.putExtra("zc_t",zc_t);
        analysis_result_calc.putExtra("ere_t",ere_t);
        analysis_result_calc.putExtra("zc_f",zc_f);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("loss",loss);
        startActivity(analysis_result_calc);
    }
}
