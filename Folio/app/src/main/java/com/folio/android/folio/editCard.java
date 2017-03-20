package com.folio.android.folio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class editCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String id = extras.getString("id");
            String firstName = extras.getString("firstName");
            String lastName = extras.getString("lastName");
            String address1 = extras.getString("address1");
            String address2 = extras.getString("address2");
            String country = extras.getString("country");
            String usState = extras.getString("usState");
            String zipCode = extras.getString("zipCode");
            String phoneNumber = extras.getString("phoneNumber");
            String city = extras.getString("city");
            String business = extras.getString("business");
        }
        else{
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }
}
