package com.example.microstripcalculator;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisResultsFinal extends AppCompatActivity {

    Double ere_final,zc_final,ere_t,zc_t,w,h,er,t;

    EditText ere_ed,zc_ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results_final);

        Intent calculated_result = getIntent();

        ere_final = calculated_result.getExtras().getDouble("ere");
        zc_final = calculated_result.getExtras().getDouble("zc");

        ere_t = calculated_result.getExtras().getDouble("ere_t");
        zc_t = calculated_result.getExtras().getDouble("zc_t");
        w = calculated_result.getExtras().getDouble("width");
        h = calculated_result.getExtras().getDouble("height");
        er = calculated_result.getExtras().getDouble("dil_constant");
        t = calculated_result.getExtras().getDouble("thickness");


        ere_ed = (EditText)findViewById(R.id.editText5);
        zc_ed = (EditText)findViewById(R.id.editText6);

        ere_ed.setText(Double.toString(ere_final));
        zc_ed.setText(Double.toString(zc_final));

    }

    public void thickness(View view){
        Intent thickness_activity = new Intent(this,AnalysisThickness.class);
        thickness_activity.putExtra("ere",ere_final);
        thickness_activity.putExtra("zc",zc_final);
        thickness_activity.putExtra("eret",ere_t);
        thickness_activity.putExtra("zct",zc_t);
        thickness_activity.putExtra("w",w);
        thickness_activity.putExtra("h",h);
        thickness_activity.putExtra("t",t);
        thickness_activity.putExtra("er",er);

        startActivity(thickness_activity);
    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainScreen.class);

        startActivity(main_activity);
    }
}
