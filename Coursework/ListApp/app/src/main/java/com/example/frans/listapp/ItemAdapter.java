package com.example.frans.listapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private ArrayList<Item> items;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final View view;
        public final TextView name;
        public final TextView price;
        public final TextView description;

        private Number itemNum;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.name = view.findViewById(R.id.itemName);
            this.description = view.findViewById(R.id.itemDescription);
            this.price = view.findViewById(R.id.itemPrice);

            this.view.setOnClickListener(this);
        }

        public void onClick(View view) {
            Intent showPictureActivity = new Intent(view.getContext(), PictureActivity.class);
            showPictureActivity.putExtra("item_index", itemNum);
            view.getContext().startActivity(showPictureActivity);
        }
    }

    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_listview_detail, viewGroup, false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        Item item = items.get(i);

        viewHolder.itemNum = i;
        viewHolder.name.setText(item.getName());
        viewHolder.description.setText(item.getDescription());
        viewHolder.price.setText(item.getPrice());
    }

    @Override
    public int getItemCount() {
        if(items != null) {
            return items.size();
        } else {
            return 0;
        }
    }
}
