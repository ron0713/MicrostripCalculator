package com.example.microstripcalculator;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisResultsFinal extends AppCompatActivity {

    Double ere_final,zc_final,w,h,er,t;

    EditText ere_ed,zc_ed;
    Double zc,ere,ere_f,zc_f,ere_t,zc_t,loss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results_final);

        Intent values = getIntent();

        zc =values.getExtras().getDouble("zc");
        ere = values.getExtras().getDouble("ere");
        zc_t = values.getExtras().getDouble("zc_t");
        ere_t =values.getExtras().getDouble("ere_t");
        ere_f = values.getExtras().getDouble("ere_f");
        zc_f = values.getExtras().getDouble("zc_f");
        loss = values.getExtras().getDouble("loss");


        ere_ed = (EditText)findViewById(R.id.editText5);
        zc_ed = (EditText)findViewById(R.id.editText6);

        ere_ed.setText(Double.toString(ere));
        zc_ed.setText(Double.toString(zc));

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
