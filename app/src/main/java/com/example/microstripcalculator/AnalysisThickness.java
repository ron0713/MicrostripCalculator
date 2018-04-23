package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisThickness extends AppCompatActivity {

    EditText zct_result, eret_result;
    Double m0,mc;
    Double w,h,er,t,ere;
    Double zc_t,ere_t,zc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_thickness);

        Intent values = getIntent();

        ere = values.getExtras().getDouble("ere");
        zc = values.getExtras().getDouble("zc");
        ere_t = values.getExtras().getDouble("eret");
        zc_t = values.getExtras().getDouble("zct");
        w = values.getExtras().getDouble("w");
        h = values.getExtras().getDouble("h");
        t = values.getExtras().getDouble("t");
        er =values.getExtras().getDouble("er");



        zct_result = (EditText)findViewById(R.id.editText14);
        eret_result = (EditText)findViewById(R.id.editText13);

        zct_result.setText(Double.toString(zc_t));
        eret_result.setText(Double.toString(ere_t));
    }

    public void frequency(View view){
        Intent content = new Intent(this,AnalysisFrequency.class);

        content.putExtra("zc_t",zc_t);
        content.putExtra("ere_t",ere_t);
        content.putExtra("w",w);
        content.putExtra("h",h);
        content.putExtra("w",w);
        content.putExtra("er",er);
        content.putExtra("t",t);
        content.putExtra("zc",zc);
        content.putExtra("ere",ere);

        startActivity(content);
    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainActivity.class);

        startActivity(main_activity);
    }
}
