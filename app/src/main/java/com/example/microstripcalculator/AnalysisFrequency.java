package com.example.microstripcalculator;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AnalysisFrequency extends AppCompatActivity {

    EditText f_ed;
    String f_str;
    Double w,h,er,ere,f,t,m0,mc,ftm,f50,m,ere_f,zc_f,zc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_frequency);

        Intent values = getIntent();

        w = values.getExtras().getDouble("w");
        h = values.getExtras().getDouble("h");
        er = values.getExtras().getDouble("er");
        ere = values.getExtras().getDouble("ere");
        t = values.getExtras().getDouble("t");
        zc = values.getExtras().getDouble("zc");
    }

    public void analysis_calc(View view){
        f_ed = (EditText)findViewById(R.id.editText15);

        f_str = f_ed.getText().toString();

        f = Double.valueOf(f_str);

        if (f_str.matches("")) {
            Toast.makeText(this, "Enter the given values", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent analysis_result_calc = new Intent(this,AnalysisFrequencyResults.class);



        ftm = (3*Math.pow(10,8))/(2*Math.PI*h*Math.sqrt(er-ere))*Math.atan(er*Math.sqrt((ere-1)/(er-ere)));

        f50 = ftm/(0.75 + (0.75 - 0.332*Math.pow(er,-1.73))*(w/h));

        m0 = 1 + 1/(1 + Math.sqrt(w/h) + 0.32*Math.pow(1/(1+Math.sqrt(w/h)),3));

        mc = (1 + (1.4/(1+(w/h)))*(0.15 - 0.235*Math.exp((-0.45*f)/f50)));

        if(w/h > 0.7)
            mc = 1d;

        m = m0*mc;

        if(m > 2.32){
            m = 2.32;
        }

        ere_f = er - (er - ere)/(1 + Math.pow(f/f50,m));

        zc_f = (((zc * (ere_f - 1) )/ ((ere - 1))) * Math.sqrt(ere/ere_f));
        Log.i("zc_f",zc_f.toString());
        Log.i("zc",zc.toString());
        Log.i("ere",ere.toString());



        analysis_result_calc.putExtra("w",w);
        analysis_result_calc.putExtra("h",h);
        analysis_result_calc.putExtra("er",er);
        analysis_result_calc.putExtra("t",t);
        analysis_result_calc.putExtra("ere_f",ere_f);
        analysis_result_calc.putExtra("zc",zc);
        analysis_result_calc.putExtra("zc_f",zc_f);

        startActivity(analysis_result_calc);

    }
}
