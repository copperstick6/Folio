package com.folio.android.folio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class businesscard extends AppCompatActivity {
    public TextView firstName;
    public TextView lastName;
    public TextView address1;
    public TextView address2;
    public TextView country;
    public TextView state;
    public TextView zipCode;
    public TextView phoneNumber;
    public TextView city;
    public TextView business;
    public Button editCard;
    public Button sendCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businesscard);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            final String id = extras.getString("id");
            final String firstName = extras.getString("firstName");
            final String lastName = extras.getString("lastName");
            final String address1 = extras.getString("address1");
            final String address2 = extras.getString("address2");
            final String country = extras.getString("country");
            final String usState = extras.getString("usState");
            final String zipCode = extras.getString("zipCode");
            final String phoneNumber = extras.getString("phoneNumber");
            final String city = extras.getString("city");
            final String business = extras.getString("business");
            getIds();
            this.firstName.setText(firstName);
            this.lastName.setText(lastName);
            this.address1.setText(address1);
            this.address2.setText(address2);
            this.country.setText(country);
            this.state.setText(usState);
            this.zipCode.setText(zipCode);
            this.phoneNumber.setText(phoneNumber);
            this.city.setText(city);
            this.business.setText(business);
            editCard = (Button) findViewById(R.id.editCard);
            editCard.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent i = new Intent(businesscard.this, editCard.class);
                    i.putExtra("id",id);
                    i.putExtra("firstName", firstName);
                    i.putExtra("lastName", lastName);
                    i.putExtra("address1", address1);
                    i.putExtra("address2", address2);
                    i.putExtra("country", country);
                    i.putExtra("usState", usState);
                    i.putExtra("zipCode", zipCode);
                    i.putExtra("phoneNumber", phoneNumber);
                    i.putExtra("city", city);
                    i.putExtra("business", business);
                    startActivity(i);

                }
            });
        }
        else{
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }
    public void getIds(){
        this.firstName = (TextView) findViewById(R.id.cardfirstName);
        this.lastName = (TextView) findViewById(R.id.cardlastName);
        this.address1 = (TextView) findViewById(R.id.cardstreetAddress);
        this.address2 = (TextView) findViewById(R.id.cardstreetAddress_2);
        this.country = (TextView) findViewById(R.id.cardCountry);
        this.state = (TextView) findViewById(R.id.cardState);
        this.zipCode = (TextView) findViewById(R.id.cardzipCode);
        this.phoneNumber = (TextView) findViewById(R.id.cardphoneNumber);
        this.city = (TextView) findViewById(R.id.cardCity);
        this.business = (TextView) findViewById(R.id.cardBusiness);
    }
}
