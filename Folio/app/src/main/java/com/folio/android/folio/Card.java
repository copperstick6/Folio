package com.folio.android.folio;

import java.util.HashMap;

/**
 * Created by copperstick6 on 3/7/17.
 */

//we need to create this object only after we validate with user data
//OpenCV could be unreliable, as we saw with the Microsoft OCR
public class Card {
    private HashMap<Character, HashMap<Integer, String>> beginningChar;

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
    private String state;
    private String mainAddress;
    private String city;
    private String position;
    //for nerds, because not everyone has a personal web address
    private String webAddress;
    //company website
    private String companyWebsite;

    /**
     *
     * This is the Card object that should be called when OCV is performed
     *
     * @param cardName      This is the name of the person on this card
     * @param cardBusiness  This is the name of the business the person works for
     * @param cardPhone     This is the phone number of the user
     * @param cardEmail     This is the email of the user
     * @param rawAdd        This is the raw address of the user, processed by OCV
     */
    public Card(String cardName, String cardBusiness, int cardPhone, String cardEmail,String rawAdd){
        this.userName = cardName;
        this.userBusiness = cardBusiness;
        this.phoneNumber = cardPhone;
        this.email = cardEmail;
        this.rawAddress = rawAdd;
        initMaps();
        processAdd();
    }

    /**
     *
     * This Card object should be called when the user manually inputs all of their data and is from the US
     *
     * @param cardName      This is the name of the person on this card
     * @param cardBusiness  This is the name of the business the person works for
     * @param cardPhone     This is the phone number of the user
     * @param cardEmail     This is the email of the user
     * @param zip           This is the zip of the user on the card
     * @param country       This is the country of the user on the card
     * @param city          This is the city of the user on the card
     * @param mainAdd       This is the main address of the user on the card
     * @param state         This is the state that the user is from
     */
    public Card(String cardName, String cardBusiness, int cardPhone, String cardEmail,int zip, String country, String city, String mainAdd, String state){
        this.userName = cardName;
        this.userBusiness = cardBusiness;
        this.phoneNumber = cardPhone;
        this.email = cardEmail;
        this.zipCode = zip;
        this.country = country;
        this.city = city;
        this.mainAddress = mainAdd;
        this.state = state;
    }

    /**
     *
     * This Card object should be called when the user manually inputs all of their data and is from the US
     *
     * @param cardName      This is the name of the person on this card
     * @param cardBusiness  This is the name of the business the person works for
     * @param cardPhone     This is the phone number of the user
     * @param cardEmail     This is the email of the user
     * @param zip           This is the zip of the user on the card
     * @param country       This is the country of the user on the card
     * @param city          This is the city of the user on the card
     * @param mainAdd       This is the main address of the user on the card
     */
    public Card(String cardName, String cardBusiness, int cardPhone, String cardEmail,int zip, String country, String city, String mainAdd){
        this.userName = cardName;
        this.userBusiness = cardBusiness;
        this.phoneNumber = cardPhone;
        this.email = cardEmail;
        this.zipCode = zip;
        this.country = country;
        this.city = city;
        this.mainAddress = mainAdd;
    }

    /**
     *This method will change the instance variable of the Card object, specifically position
     *
     * @param position  This is the position the user holds
     * @return  Return true if position is changed, false otherwise
     */
    public boolean setPosition(String position){
        if(position == null || position.length() == 0){
            return false;
        }
        this.position = position;
        return true;
    }


    //we need to use google maps to process
    //TODO implement Google Maps
    /**
     *
     * This method will process the raw address inputted as a result of the OCR process
     * it will process the main address and then call the google maps API to retrieve all other data
     *
     */
    public void processAdd(){
        String mainAddress = this.rawAddress.substring(0, this.rawAddress.indexOf(","));
        this.mainAddress = mainAddress;

    }


    //TODO need to add the postal codes one by one >.> Pain in the ass, but will do later
    //TODO need to unit test to check if all postal tests were added properly
    /**
     * This method will initalize all the addresses and then we can perform our own check to see if the address is actually an address
     * before we pass it into google maps API
     */
    public void initMaps(){


    }
}