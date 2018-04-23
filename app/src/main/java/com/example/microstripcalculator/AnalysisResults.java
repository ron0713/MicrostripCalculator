package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnalysisResults extends AppCompatActivity {

    Double w,h,t,er,u,a,b,ere,v,x,zc_result,f,d;
    Double wet_h,c1,c2,c3,c4,ere_t,zc_result_t;
    Double ftm,f50,m0,mc,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_results);

        Intent values = getIntent();

        w = Double.valueOf(values.getExtras().getString("width"));
        h = Double.valueOf(values.getExtras().getString("height"));
        er = Double.valueOf(values.getExtras().getString("dil_constant"));
        t = Double.valueOf(values.getExtras().getString("thickness"));

        u = w / h;

        v = Math.log((Math.pow(u,4) + Math.pow(u/52,2)) / (Math.pow(u,4)+0.432));

        x =  1 + Math.pow(u/18.1,3);

        a = 1 + (1/49)*v + (1/18.7)*Math.log(x);

        b = 0.564*(Math.pow(  (er-0.9)/(er+3) , 0.053   ) );

        ere = (er+1)/2  + ((er-1)/2)*Math.pow(1+(10/u),-a*b);

        f = 6 + (2*Math.PI - 6)*Math.exp(-Math.pow(  (30.666/u),0.7528  ));

        d = (f/u) + Math.pow(1+((2/u)*(2/u)),0.5);

        zc_result = (60/ere)*Math.log(d);

        c1  = (1.25*t)/(Math.PI*h);

        c2 = 1 + Math.log((4*Math.PI*w)/t);

        c3 = 1 + Math.log((2*h)/t);

        if(u <= 0.5*Math.PI){
            wet_h = u + c1*c2;
        } else {
            wet_h = u + c1*c3;
        }

        ere_t = ere - ((er-1)*(t/h))/(4.6*Math.sqrt(w/h));

        c1 = wet_h/h;

        c2 = 120*Math.PI/Math.sqrt(ere);

        if(u <= 1){
            zc_result_t = (c2/(2*Math.PI))*Math.log(8/c1 + 0.25*c1);
        } else {
            zc_result_t = (c2)/(c1 + 1.393 + 0.667*Math.log(c1 + 1.444));
        }







    }

    public void show_result_analysis(View view){
        Intent final_result_analysis = new Intent(this,AnalysisResultsFinal.class);

        final_result_analysis.putExtra("ere",ere);
        final_result_analysis.putExtra("zc",zc_result);
        final_result_analysis.putExtra("width",w);
        final_result_analysis.putExtra("height",h);
        final_result_analysis.putExtra("dil_constant",er);
        final_result_analysis.putExtra("thickness",t);
        final_result_analysis.putExtra("ere_t",ere_t);
        final_result_analysis.putExtra("zc_t",zc_result_t);

        startActivity(final_result_analysis);
    }
}
