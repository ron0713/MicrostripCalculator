package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisFrequencyResults extends AppCompatActivity {
    EditText ere_ed,zc_ed;
    Double w,h,er,t,ere_f,zc_f,zc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_frequency_results);

        Intent values = getIntent();
        w = values.getExtras().getDouble("w");
        h = values.getExtras().getDouble("h");
        er = values.getExtras().getDouble("er");
        t = values.getExtras().getDouble("t");
        ere_f = values.getExtras().getDouble("ere_f");
        zc_f = values.getExtras().getDouble("zc_f");
        zc = values.getExtras().getDouble("zc");

        ere_ed = (EditText)findViewById(R.id.editText15);
        zc_ed = (EditText)findViewById(R.id.editText16);

        ere_ed.setText(Double.toString(ere_f));
        zc_ed.setText(Double.toString(zc_f));
    }

    public void losses(View view){
        Intent content = new Intent(this,AnalysisLosses.class);

        content.putExtra("w",w);
        content.putExtra("h",h);
        content.putExtra("er",er);
        content.putExtra("t",t);
        content.putExtra("ere_f",ere_f);
        content.putExtra("zc_f",zc_f);
        content.putExtra("zc",zc);


        startActivity(content);
    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainScreen.class);
        startActivity(main_activity);
    }
}
