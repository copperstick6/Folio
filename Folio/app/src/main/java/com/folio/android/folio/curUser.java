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
    private ArrayList<Cards> curCards;
    public curUser(){
        //user starts with zero cards
        this.numCards = 0;
        //default number of cards is 15
        this.limit = 15;
        this.curCards = new ArrayList<Cards>();
    }
    public void limitIncrease(){
        //if user purchases extra cards, we increment limit.
        this.limit += 10;

    }
    //checks if we can add one more card
    public boolean canAdd(){
        if((numCards +1)< limit){
            return true;
        }
        return false;
    }

    public int getNumCards(){
        return this.numCards;
    }
    public boolean addCard(Cards addCard){
        if(canAdd()){
            curCards.add(addCard);
            return true;
        }
        return false;
    }

}
