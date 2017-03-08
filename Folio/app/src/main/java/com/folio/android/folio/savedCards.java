package com.folio.android.folio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class savedCards extends AppCompatActivity {
    public Button manual_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_cards);
        manual_input = (Button) findViewById(R.id.add_manual);
        manual_input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(savedCards.this, Manual_Input.class);
                startActivity(i);
            }
        });

    }
}
