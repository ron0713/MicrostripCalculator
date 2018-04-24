package com.example.microstripcalculator;

import android.content.Intent;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {

    Double w,h,er,t,c,f,ere_f,zc_f,rs,ac;
    EditText w_ed,h_ed,er_ed,t_ed,c_ed,fr_ed;


    Double u,a,b,ere,v,x,zc_result,d;
    Double wet_h,c1,c2,c3,c4,ere_t,zc_result_t;
    Double ftm,f50,m0,mc,m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        Intent main_intent = getIntent();
    }

    public void analysis_calc(View view){

        w_ed = (EditText)findViewById(R.id.editText2);
        h_ed = (EditText)findViewById(R.id.editText);
        er_ed = (EditText)findViewById(R.id.editText3);
        t_ed = (EditText)findViewById(R.id.editText7);
        fr_ed =  (EditText)findViewById(R.id.editText15);
        c_ed = (EditText)findViewById(R.id.editText17);

        if (w_ed.getText().toString().matches("") ||h_ed.getText().toString().matches("")
                ||er_ed.getText().toString().matches("") ||t_ed.getText().toString().matches("")
                ||fr_ed.getText().toString().matches("") || c_ed.getText().toString().matches("")) {
            Toast.makeText(this, "Enter the given values", Toast.LENGTH_SHORT).show();
            return;
        }

        w = Double.valueOf(w_ed.getText().toString());
        h = Double.valueOf(h_ed.getText().toString());
        er = Double.valueOf(er_ed.getText().toString());
        t = Double.valueOf(t_ed.getText().toString());
        c = Double.valueOf(c_ed.getText().toString());
        f = Double.valueOf(fr_ed.getText().toString()) * Math.pow(10,9);

        u = w / h;

        v = Math.log((Math.pow(u,4) + Math.pow(u/52,2)) / (Math.pow(u,4)+0.432));

        x =  1 + Math.pow(u/18.1,3);

//        a = 1 + (1/49)*v + (1/18.7)*Math.log(x);
//
//        b = 0.564*(Math.pow(  (er-0.9)/(er+3) , 0.053   ) );
//
//        ere = (er+1)/2  + ((er-1)/2)*Math.pow(1+(10/u),-a*b);

        if(u <= 1){
           ere = (er+1)/2 + ((er-1)/2)*(Math.pow(1+12*(h/w),-0.5) + 0.04*(1-u)*(1-u));
        }else {
            ere = (er+1)/2 + ((er-1)/2)*(Math.pow(1+12*(h/w),-0.5));
        }

//        f = 6 + (2*Math.PI - 6)*Math.exp(-Math.pow(  (30.666/u),0.7528  ));
//
//        d = (f/u) + Math.pow(1+((2/u)*(2/u)),0.5);

//        zc_result = (60/ere)*Math.log(d);

        if(u<=1){
            zc_result = (60/Math.sqrt(ere))*Math.log((8*h)/w+0.25*u);
        } else {
            zc_result = ((120*Math.PI)/Math.sqrt(ere)) / (u + 1.393 + 0.677*Math.log(u+1.444));
        }
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

        zc_f = (((zc_result * (ere_f - 1) )/ ((ere - 1))) * Math.sqrt(ere/ere_f));



        rs = Math.sqrt( (2*Math.PI*f*1.26*Math.pow(10,-6))/(2*c) );
        ac = (8.686*rs)/(zc_result*w);


        Log.i("zc",zc_result.toString());
        Log.i("ere",ere.toString());
        Log.i("zc_t",zc_result_t.toString());
        Log.i("ere_t",ere_t.toString());
        Log.i("zc_f",zc_f.toString());
        Log.i("ere_f",ere_f.toString());

            Intent analysis_result_calc = new Intent(this,AnswerScreen.class);

            analysis_result_calc.putExtra("zc",zc_result);
            analysis_result_calc.putExtra("ere",ere);
            analysis_result_calc.putExtra("zc_t",zc_result_t);
            analysis_result_calc.putExtra("ere_t",ere_t);
            analysis_result_calc.putExtra("zc_f",zc_f);
            analysis_result_calc.putExtra("ere_f",ere_f);
            analysis_result_calc.putExtra("loss",ac);

            startActivity(analysis_result_calc);


    }


}
