package com.folio.android.folio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addChoiceActivity extends AppCompatActivity {
    public Button manual_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_choice);
        //Button to start the form
        //Needs migration over to a new Activity Screen where we have two buttons
        //OCV or manual add
        manual_input = (Button) findViewById(R.id.add_OCV);
        manual_input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(addChoiceActivity.this, Manual_Input.class);
                startActivity(i);
            }
        });
    }
}
