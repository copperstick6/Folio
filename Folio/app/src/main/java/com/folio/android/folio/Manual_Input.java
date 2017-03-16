package com.folio.android.folio;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This Activity is called whenever the user selects to manually input the data
 */
public class Manual_Input extends AppCompatActivity {
    public Button onClick;
    public EditText firstName;
    public EditText lastName;
    public EditText address1;
    public EditText address2;
    public Spinner  country;
    public Spinner  usState;
    public EditText zipCode;
    public EditText phoneNumber;
    public EditText city;
    public EditText business;
    public cardDB cards;
    public Button getAll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__input);
        countrySpinner();
        stateSpinner();
        cards = new cardDB(this);
        addCardBtn();
        getAllBtn();

    }

    private void getAllBtn(){
        getAll = (Button) findViewById(R.id.view_all);
        getAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Cursor cur = cards.getAllData();
                if(cur.getCount() == 0){
                    showMessage("Error", "No data to show!");
                    return;
                }
                else{
                    StringBuffer buffer = new StringBuffer();
                    while(cur.moveToNext()){
                        buffer.append("Id: "+ cur.getString(0) + "\n");
                        buffer.append("First Name: "+ cur.getString(1) + "\n");
                        buffer.append("Last Name: "+ cur.getString(2) + "\n");
                        buffer.append("Address 1: "+ cur.getString(3) + "\n");
                        buffer.append("Address 2: "+ cur.getString(4) + "\n");
                        buffer.append("Country: "+ cur.getString(5) + "\n");
                        buffer.append("State: "+ cur.getString(6) + "\n");
                        buffer.append("Zip Code: "+ cur.getString(7) + "\n");
                        buffer.append("Phone Number: "+ cur.getString(8) + "\n");
                        buffer.append("City: "+ cur.getString(9) + "\n");
                        buffer.append("Business: "+ cur.getString(10) + "\n\n");
                    }
                    showMessage("Data", buffer.toString());
                }

            }
        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void addCardBtn() {
        onClick = (Button) findViewById(R.id.addCard);
        onClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                boolean emptyField = false;
                initializeFieldListeners();
                initializeSizeRestraints();
                if(firstName.getText().toString().length() == 0){
                    firstName.setError("First Name is required!");
                    emptyField = true;
                }
                if(lastName.getText().toString().length() == 0){
                    lastName.setError("Last Name is required!");
                    emptyField = true;
                }
                if(address1.getText().toString().length() == 0){
                    address1.setError("Address is required!");
                    emptyField = true;
                }
                if(country.getSelectedItem().toString().equals("USA") && usState.getSelectedItem().toString().equals("N/A")){
                    ((TextView)usState.getSelectedView()).setError("Invalid State!");
                    emptyField = true;
                }
                if(zipCode.getText().toString().length() != 5){
                    zipCode.setError("Invalid Zip Code!");
                    emptyField = true;
                }
                if(phoneNumber.getText().toString().length() != 10){
                    phoneNumber.setError("Invalid Phone Number!");
                    emptyField = true;
                }
                if(city.getText().toString().length() == 0){
                    city.setError("Invalid City!");
                    emptyField = true;
                }
                if(business.getText().toString().length() == 0){
                    business.setError("Invalid Business!");
                    emptyField = true;
                }
                if(!emptyField){
                    //add to Form
                    boolean inserted = insert();
                    if(inserted){
                        Toast.makeText(Manual_Input.this, "Inputted!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Manual_Input.this, "not added", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    public boolean insert(){
        String firstname = firstName.getText().toString();
        String lastname = lastName.getText().toString();
        String address1 = this.address1.getText().toString();
        String address2 = this.address2.getText().toString();
        String country = this.country.getSelectedItem().toString();
        String usState = this.usState.getSelectedItem().toString();
        String zipcode = this.zipCode.getText().toString();
        String phoneNumber = this.phoneNumber.getText().toString();
        String city = this.city.getText().toString();
        String business = this.business.getText().toString();
        if(address2.length() == 0){
            address2 = "null";
        }
        return cards.insert(firstname, lastname, address1, address2, country, usState, zipcode, phoneNumber, city, business);

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
    private void stateSpinner(){
        Spinner stateSpinner = (Spinner) findViewById(R.id.state_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(this, R.array.stateCodes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        stateSpinner.setAdapter(stateAdapter);
    }

    private void initializeFieldListeners(){
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        address1 = (EditText) findViewById(R.id.streetAddress);
        address2 = (EditText) findViewById(R.id.streetAddress_2);
        country = (Spinner)findViewById(R.id.country_spinner);
        usState = (Spinner) findViewById(R.id.state_spinner);
        zipCode = (EditText) findViewById(R.id.zipCode);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        city = (EditText) findViewById(R.id.city);
        business = (EditText) findViewById(R.id.business);
    }
    private void initializeSizeRestraints(){
        //making sure that the fields won't stretch their width
        firstName.setMaxWidth(firstName.getWidth());
        lastName.setMaxWidth(lastName.getWidth());
        address1.setMaxWidth(address1.getWidth());
        address2.setMaxWidth(address2.getWidth());
        zipCode.setMaxWidth(zipCode.getWidth());
        phoneNumber.setMaxWidth(phoneNumber.getWidth());
        city.setMaxWidth(city.getWidth());
        business.setMaxWidth(business.getWidth());

        //making sure that the fields won't stretch their given height

        firstName.setMaxHeight(firstName.getHeight());
        lastName.setMaxHeight(lastName.getHeight());
        address1.setMaxHeight(address1.getHeight());
        address2.setMaxHeight(address2.getHeight());
        zipCode.setMaxHeight(zipCode.getHeight());
        phoneNumber.setMaxHeight(phoneNumber.getHeight());
        city.setMaxHeight(city.getHeight());
        business.setMaxHeight(business.getHeight());
    }
}
