package com.folio.android.folio;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by copperstick6 on 3/16/17.
 */

public class cardFragment extends Fragment {
    private RecyclerView mRecyclerView;
    public cardDB cards;
    private cardAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.cardlist, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.cardlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }
    public void updateUI(){
        cards = new cardDB(this.getContext());
        Cursor cur = cards.getAllData();
        ArrayList<ArrayList<String>> allCards = new ArrayList<ArrayList<String>>();
        while(cur.moveToNext()){
            ArrayList<String> obj1 = new ArrayList<String>();
            obj1.add(cur.getString(0));
            obj1.add(cur.getString(1));
            obj1.add(cur.getString(2));
            obj1.add(cur.getString(3));
            obj1.add(cur.getString(4));
            obj1.add(cur.getString(5));
            obj1.add(cur.getString(6));
            obj1.add(cur.getString(7));
            obj1.add(cur.getString(8));
            obj1.add(cur.getString(9));
            obj1.add(cur.getString(10));
            allCards.add(obj1);
        }
        adapter = new cardAdapter(allCards);
        mRecyclerView.setAdapter(adapter);


    }
    private class cardHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTitleTextView;
        public cardHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView) itemView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //TODO I just need to pass the adapter position between intents! Hype!
            //Toast.makeText(getActivity(), "User clicked!" + " " + this.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            //need to switch between intents and pass data into intent.
            Cursor cur = cards.getAllData();
            for(int i = 0; i < this.getAdapterPosition() + 1; i++){
                cur.moveToNext();
            }
            //TODO Create a new intent with user business card data
            Intent i = new Intent(getContext(), businesscard.class);
            i.putExtra("id", cur.getString(0));
            i.putExtra("firstName", cur.getString(1));
            i.putExtra("lastName", cur.getString(2));
            i.putExtra("address1", cur.getString(3));
            i.putExtra("address2", cur.getString(4));
            i.putExtra("country", cur.getString(5));
            i.putExtra("usState", cur.getString(6));
            i.putExtra("zipCode", cur.getString(7));
            i.putExtra("phoneNumber", cur.getString(8));
            i.putExtra("city", cur.getString(9));
            i.putExtra("business", cur.getString(10));
            startActivity(i);

        }
    }
    private class cardAdapter extends RecyclerView.Adapter<cardHolder>{
        private ArrayList<ArrayList<String>> allCards;
        public cardAdapter(ArrayList<ArrayList<String>> cards){
            allCards = cards;
        }
        @Override
        public cardHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new cardHolder(view);
        }
        @Override
        public void onBindViewHolder(cardHolder holder, int position){
            ArrayList<String> curObject = allCards.get(position);
            holder.mTitleTextView.setText(curObject.get(1) + " " + curObject.get(2));

        }
        @Override
        public int getItemCount(){
            return allCards.size();
        }
    }
}
