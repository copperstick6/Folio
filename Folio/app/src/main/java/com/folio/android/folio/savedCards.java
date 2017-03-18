package com.folio.android.folio;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class savedCards extends FragmentActivity {
    //TODO: ADD THE ADD CARD BUTTON AS A FRAGMENT, REDESIGN THE UI LATER

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_cards);
        fragmentStarter();
        //Intent i = new Intent(savedCards.this, addChoiceActivity.class);
        //startActivity(i);
    }
    public void fragmentStarter(){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.activity_saved_cards);
        if(fragment == null){
            fragment = new cardFragment();
            fm.beginTransaction().add(R.id.activity_saved_cards, fragment).commit();
        }
    }
}
