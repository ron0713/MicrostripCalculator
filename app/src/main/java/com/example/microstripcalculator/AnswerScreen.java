package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerScreen extends AppCompatActivity {

    Double zc,ere,zc_t,ere_t,zc_f,ere_f,loss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_screen);

        Intent values = getIntent();

        zc =values.getExtras().getDouble("zc");
        ere = values.getExtras().getDouble("ere");
        zc_t = values.getExtras().getDouble("zc_t");
        ere_t =values.getExtras().getDouble("ere_t");
        ere_f = values.getExtras().getDouble("ere_f");
        zc_f = values.getExtras().getDouble("zc_f");
        loss = values.getExtras().getDouble("loss");
    }

    public void one(View view) {
        Intent analysis_result_calc = new Intent(this,AnalysisResultsFinal.class);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("ere",ere);
        analysis_result_calc.putExtra("zc_t",zc_t);
        analysis_result_calc.putExtra("ere_t",ere_t);
        analysis_result_calc.putExtra("zc_f",zc_f);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("loss",loss);

        startActivity(analysis_result_calc);
    }

    public void two(View view) {
        Intent analysis_result_calc = new Intent(this,AnalysisThickness.class);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("ere",ere);
        analysis_result_calc.putExtra("zc_t",zc_t);
        analysis_result_calc.putExtra("ere_t",ere_t);
        analysis_result_calc.putExtra("zc_f",zc_f);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("loss",loss);

        startActivity(analysis_result_calc);
    }

    public void three(View view) {
        Intent analysis_result_calc = new Intent(this,AnalysisFrequencyResults.class);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("ere",ere);
        analysis_result_calc.putExtra("zc_t",zc_t);
        analysis_result_calc.putExtra("ere_t",ere_t);
        analysis_result_calc.putExtra("zc_f",zc_f);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("loss",loss);

        startActivity(analysis_result_calc);
    }

    public void four(View view) {
        Intent analysis_result_calc = new Intent(this,AnalysisLossesResults.class);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("ere",ere);
        analysis_result_calc.putExtra("zc_t",zc_t);
        analysis_result_calc.putExtra("ere_t",ere_t);
        analysis_result_calc.putExtra("zc_f",zc_f);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("loss",loss);

        startActivity(analysis_result_calc);
    }

    public void home(View view) {
        Intent analysis_result_calc = new Intent(this,MainScreen.class);
        startActivity(analysis_result_calc);
    }
}
