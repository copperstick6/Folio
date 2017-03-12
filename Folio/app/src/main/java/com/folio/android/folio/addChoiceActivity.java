package com.folio.android.folio;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addChoiceActivity extends AppCompatActivity {
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

                Intent i = new Intent(addChoiceActivity.this, Manual_Input.class);
                startActivity(i);
            }
        });
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        manual_input = (Button) findViewById(R.id.add_manual);
        manual_input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                URLConnectionReader connect = new URLConnectionReader("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCDw3K_2g9Iw-kPciTLhs-LLjUc65Lu-mU");
                try{
                    System.out.println("entered");
                    connect.getHTML();
                }
                catch(Exception a){
                    System.out.println("Caught");
                    a.printStackTrace();
                }
            }
        });
    }
}
