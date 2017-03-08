package com.folio.android.folio;

/**
 * Created by copperstick6 on 3/7/17.
 */

//we need to create this object only after we validate with user data
//OpenCV could be unreliable, as we saw with the Microsoft OCR
public class Card {

    //critical user information
    private String userName;
    private String userBusiness;
    private int phoneNumber;
    private String email;
    private String rawAddress;

    //Address format should be as follows: mainAddress, secondary line, city, State, Country
    //However, we should use Google Maps to validate
    //so we should just process the main address and then call the google maps API

    private int zipCode;
    private String country;
    private String city;
    private String mainAddress;


    private String position;

    //for nerds, because not everyone has a personal web address
    private String webAddress;

    //company website
    private String companyWebsite;
    public Card(String cardName, String cardBusiness, int cardPhone, String cardEmail,String rawAdd){
        this.userName = cardName;
        this.userBusiness = cardBusiness;
        this.phoneNumber = cardPhone;
        this.email = cardEmail;
        this.rawAddress = rawAdd;
        processAdd(rawAdd);
    }

    public void processAdd(String rawAddress){
        int commaChar = rawAddress.indexOf(",");
        String mainAddress = rawAddress.substring(0, commaChar);
        this.mainAddress = mainAddress;
        

    }
}