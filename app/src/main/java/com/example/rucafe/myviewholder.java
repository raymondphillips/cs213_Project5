package com.example.rucafe;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/**
 * a class to hold the my view
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class myviewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView header, desc;
    int selectedPos;

    /**
     * a method to hold the view item
     * @param itemView takes in a view
     */
    public myviewholder(@NonNull View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.img1);
        header = itemView.findViewById(R.id.t1);
        desc = itemView.findViewById(R.id.t2);
    }
}
