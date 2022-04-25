package com.example.rucafe;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import cafe.Donut;

/**
 * A simple {@link Fragment} subclass.
 * Use the factory method to
 * create an instance of this fragment.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class donut extends Fragment {

    RecyclerView donutSelecter;
    ArrayList<donutModel> dataholder;
    private View view;
    private Button donutOrder;
    private static final int quant = 1;

    /**
     * a method to create the view of the fragment
     * @param inflater an LayoutInflator object
     * @param container a ViewGroup object
     * @param savedInstanceState a Bundle object of the previous savedInstanceState
     * @return the view to be displaced
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_donut, container, false);
        donutSelecter = view.findViewById(R.id.donut_selection);
        donutSelecter.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder = new ArrayList<>();

        donutModel ob1 = new donutModel(R.drawable.cakedonutglaze, "Cake Donut Glazed", "$1.79");
        dataholder.add(ob1);
        donutModel ob2 = new donutModel(R.drawable.cakedonutplain, "Cake Donut Plain", "$1.79");
        dataholder.add(ob2);
        donutModel ob3 = new donutModel(R.drawable.cakedonutpowdered, "Cake Donut Powdered", "$1.79");
        dataholder.add(ob3);
        donutModel ob4 = new donutModel(R.drawable.cakedonutsprinkles, "Cake Donut Sprinkles", "$1.79");
        dataholder.add(ob4);

        donutModel ob5 = new donutModel(R.drawable.yeastdonutglaze, "Yeast Donut Glazed", "$1.59");
        dataholder.add(ob5);
        donutModel ob6 = new donutModel(R.drawable.yeastdonutplain, "Yeast Donut Plain", "$1.59");
        dataholder.add(ob6);
        donutModel ob7 = new donutModel(R.drawable.yeastdonutpowdered, "Yeast Donut Powdered", "$1.59");
        dataholder.add(ob7);
        donutModel ob8 = new donutModel(R.drawable.yeastdonutsprinkles, "Yeast Donut Sprinkles", "$1.59");
        dataholder.add(ob8);

        donutModel ob9 = new donutModel(R.drawable.donutholeglaze, "Hole Donut Glazed", "$0.39");
        dataholder.add(ob9);
        donutModel ob10 = new donutModel(R.drawable.donutholeplain, "Hole Donut Plain", "$0.39");
        dataholder.add(ob10);
        donutModel ob11 = new donutModel(R.drawable.donutholepowdered, "Hole Donut Powdered", "$0.39");
        dataholder.add(ob11);
        donutModel ob12 = new donutModel(R.drawable.donutholesprinkles, "Hole Donut Sprinkles", "$0.39");
        dataholder.add(ob12);

        donutSelecter.setAdapter(new recyclerAdapter(dataholder));

        donutOrder = (Button) view.findViewById(R.id.donutOrder);
        donutOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://stackoverflow.com/questions/53154171/retrieve-data-from-recyclerview
                int pos = MainActivity.donutPosition;
                //System.out.println(dataholder.get(pos).getHeader());
                String[] donutArgs = dataholder.get(pos).getHeader().split(" ");
                Donut donut = new Donut(donutArgs[2], donutArgs[0], quant);
                MainActivity.menuItemList.add(donut);

            }
        });

        return view;
    }
}