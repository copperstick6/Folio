package com.folio.android.folio;

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
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.cardlist, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.cardlist);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
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
            holder.mTitleTextView.setText(curObject.get(1));
        }
        @Override
        public int getItemCount(){
            return allCards.size();
        }
    }
}
