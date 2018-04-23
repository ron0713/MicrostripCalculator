package com.example.microstripcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AnalysisLossesResults extends AppCompatActivity {

    Double loss;
    EditText loss_ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_losses_results);

        Intent values = getIntent();

        loss = values.getExtras().getDouble("loss");

        loss_ed = (EditText)findViewById(R.id.editText18);

        loss_ed.setText(Double.toString(loss));
    }

    public void back_home_main(View view){
        Intent main_activity = new Intent(this,MainScreen.class);

        startActivity(main_activity);
    }
}
