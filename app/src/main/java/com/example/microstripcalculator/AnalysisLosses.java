package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.DeflaterOutputStream;

public class AnalysisLosses extends AppCompatActivity {
    EditText f_ed,c_ed;
    String f_str,c_str;
    Double w,h,er,t,ere_f,zc_f,zc,f,c,rs,ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_losses);

        Intent values = getIntent();

        w =values.getExtras().getDouble("w");
        h = values.getExtras().getDouble("h");
        er = values.getExtras().getDouble("er");
        t =values.getExtras().getDouble("t");
        ere_f = values.getExtras().getDouble("ere_f");
        zc_f = values.getExtras().getDouble("zc_f");
        zc = values.getExtras().getDouble("zc");
    }

    public void analysis_calc(View view){
        f_ed = (EditText)findViewById(R.id.editText18);
        c_ed = (EditText)findViewById(R.id.editText17);
        f_str = f_ed.getText().toString();
        c_str = c_ed.getText().toString();
        f = Double.valueOf(f_ed.getText().toString());
        c = Double.valueOf(c_ed.getText().toString());

        if (f_str.matches("") || c_str.matches("")) {
            Toast.makeText(this, "Enter the given values", Toast.LENGTH_SHORT).show();
            return;
        }

        rs = Math.sqrt((2*Math.PI*f*1.26*Math.pow(10,-6))/(2*c));
        ac = (8.686*rs)/(zc*w);
        Log.i("rs",rs.toString());
        Log.i("zc",zc.toString());
        Log.i("w",w.toString());
        Log.i("freq",f.toString());
        Log.i("cond",c.toString());
        Intent analysis_result_calc = new Intent(this,AnalysisLossesResults.class);

        Intent values = getIntent();


        analysis_result_calc.putExtra("loss",ac);

        startActivity(analysis_result_calc);

    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainActivity.class);

        startActivity(main_activity);
    }
}
