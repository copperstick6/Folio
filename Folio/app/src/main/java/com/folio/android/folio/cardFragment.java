package com.folio.android.folio;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private class cardHolder extends RecyclerView.ViewHolder{
        public TextView mTitleTextView;
        public cardHolder(View itemView){
            super(itemView);
            mTitleTextView = (TextView) itemView;
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
