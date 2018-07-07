package com.alesterlewis.generallibraryapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Alester Lewis on 5/9/2018.
 */

class AdapterExample extends RecyclerView.Adapter<AdapterExample.ViewHolder> {
    ArrayList<String> mContacts;

    public AdapterExample(ArrayList<String> contacts){
        mContacts = contacts;
    }




    @NonNull
    @Override
    public AdapterExample.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterExample.ViewHolder holder, int position) {
        holder.mFullName.setText(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mFullName;
        public ViewHolder(View itemView) {
            super(itemView);

            mFullName = itemView.findViewById(R.id.full_name);
        }
    }
}
