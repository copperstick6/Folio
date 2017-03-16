package com.folio.android.folio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class savedCards extends AppCompatActivity {
    public cardDB cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cards = new cardDB(this);
        setContentView(R.layout.activity_saved_cards);
        Intent i = new Intent(savedCards.this, addChoiceActivity.class);
        startActivity(i);

    }
}
