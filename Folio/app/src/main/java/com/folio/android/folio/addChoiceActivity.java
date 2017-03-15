package com.folio.android.folio;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addChoiceActivity extends AppCompatActivity {
    private static final String TAG = "addChoiceActivity";
    public Button OCV_input;
    public Button manual_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_choice);
        //Button to start the form
        //Needs migration over to a new Activity Screen where we have two buttons
        //OCV or manual add
        OCV_input = (Button) findViewById(R.id.add_OCV);
        OCV_input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                Toast.makeText(addChoiceActivity.this, R.string.add_OCV, Toast.LENGTH_SHORT).show();
                Log.i(TAG, "clicked on Add Cards Automatically");
                Intent i = new Intent(addChoiceActivity.this, Camera.class);
                startActivity(i);
            }
        });

        manual_input = (Button) findViewById(R.id.add_manual);
        manual_input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(addChoiceActivity.this, Manual_Input.class);
                startActivity(i);

            }
        });
    }
}
