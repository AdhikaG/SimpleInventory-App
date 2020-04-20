package com.first.utsmcs;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    List<Items> ListInventory;
    Context iContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemDesc;
        TextView itemQty;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.home_Name);
            itemDesc = itemView.findViewById(R.id.home_Description);
            itemQty = itemView.findViewById(R.id.home_Qty);
            iContext = itemView.getContext();




        }

//        @Override
//        public void onClick(View view) {
//
//            Intent intent = new Intent();
//            switch (getAdapterPosition()){
//                case 0:
//                    intent =  new Intent(iContext, Edit_Item_Activity.class);
//                    break;
//
//                default:
//
//            }
//            iContext.startActivity(intent);
//        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View MyViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.content, parent, false);
        return new ViewHolder(MyViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Items ItemsData = Bridge.InDB.itemsA.get(position);
        holder.itemName.setText(ItemsData.getItemName());
        holder.itemDesc.setText((ItemsData.getItemDescription()));
        holder.itemQty.setText((ItemsData.getItemQuantity()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(iContext, Edit_Item_Activity.class);
                iContext.startActivity(intent);

            }


        });
    }

    @Override
    public int getItemCount() {

        return Bridge.InDB.itemsA.size();
    }

}