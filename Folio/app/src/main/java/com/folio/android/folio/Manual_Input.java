package com.folio.android.folio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Manual_Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__input);
        countrySpinner();
        stateSpinner();
    }

    /**
     * Method to initialize the country spinner, by calling an adapter and creating a new Spinner object using R.id
     */
    public void countrySpinner(){
        Spinner countrySpinner = (Spinner) findViewById(R.id.country_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(this, R.array.countryCodes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        countrySpinner.setAdapter(countryAdapter);
    }

    /**
     * Method to initialize the state spinner by calling an adapter and creating a new Spinner object using R.id
     */
    public void stateSpinner(){
        Spinner stateSpinner = (Spinner) findViewById(R.id.state_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this, R.array.stateCodes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        stateSpinner.setAdapter(stateAdapter);
    }
}
