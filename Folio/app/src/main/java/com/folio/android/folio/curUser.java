package com.folio.android.folio;

/**
 * Created by copperstick6 on 3/7/17.
 */
import java.util.ArrayList;

//Creating a new object for each new user
//All user Data will be held here, we're even going to add card data here
//We will store this into local cache
public class curUser {

    private int numCards;
    private int limit;
    private ArrayList<Card> curCards;
    private boolean first;

    /**
     * Default Constructor to create a new user object for the current user
     * Everyone starts with 0 cards and a limit of 15
     * Everything will be stored locally to decrease costs
     */
    public curUser(){
        //user starts with zero cards
        this.numCards = 0;
        //default number of cards is 15
        this.limit = 15;
        this.curCards = new ArrayList<Card>();
        this.first = false;
    }

    /**
     * If we detect that the user pays for something, we're going to increase the limit
     */
    public void limitIncrease(){
        //if user purchases extra cards, we increment limit.
        this.limit += 10;

    }
    //checks if we can add one more card

    /**
     * Method to check if adding is possible or not
     * @return Return true if adding is possible, False otherwise
     */
    public boolean canAdd(){
        if((numCards +1)< limit){
            return true;
        }
        return false;
    }

    /**
     * Method to get the number of cards the current user has used
     * @return Return the number of cards the current user has used
     */
    public int getNumCards(){
        return this.numCards;
    }

    /**
     * Method to add a card object to the arraylist of cards instance variable
     * @param addCard   This is the Card to be added into the ArrayList
     * @return      Return true if it can be added, false otherwise
     */
    public boolean addCard(Card addCard){
        if(canAdd()){
            curCards.add(addCard);
            return true;
        }
        return false;
    }

}
