package com.example.rucafe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cafe.Coffee;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link coffee} factory method to
 * create an instance of this fragment.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class coffee extends Fragment{
    View view;
    private String currentSelectedSize;
    private Button orderCoffee;
    private CheckBox whipped_cream, milk, caramel, syrup, cream;

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
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.fragment_coffee, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.coffeeSize);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.coffeeSizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * do something on item selected
             * @param adapterView takes an arraylist adapterview
             * @param view takes a view View
             * @param i an int i
             * @param l a long l
             */
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
                currentSelectedSize = text;
            }

            /**
             * a method to do something when nothing is selected
             * @param parent takes in an adapter view arraylist
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //nothing to do here
            }
        });

        whipped_cream = (CheckBox) view.findViewById(R.id.whipped_cream);
        milk = (CheckBox) view.findViewById(R.id.milk);
        caramel = (CheckBox) view.findViewById(R.id.caramel);
        syrup = (CheckBox) view.findViewById(R.id.syrup);
        cream = (CheckBox) view.findViewById(R.id.cream);

        List<String> addins = new ArrayList<String>();

        whipped_cream.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(whipped_cream.isChecked()){
                    addins.add(getResources().getResourceEntryName(R.id.whipped_cream));
                } else{
                    addins.remove(getResources().getResourceEntryName(R.id.whipped_cream));
                }
            }
        });

        milk.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(milk.isChecked()){
                    addins.add(getResources().getResourceEntryName(R.id.milk));
                } else{
                    addins.remove(getResources().getResourceEntryName(R.id.milk));
                }
            }
        });

        caramel.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(caramel.isChecked()){
                    addins.add(getResources().getResourceEntryName(R.id.caramel));
                } else{
                    addins.remove(getResources().getResourceEntryName(R.id.caramel));
                }
            }
        });

        syrup.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(syrup.isChecked()){
                    addins.add(getResources().getResourceEntryName(R.id.syrup));
                } else{
                    addins.remove(getResources().getResourceEntryName(R.id.syrup));
                }
            }
        });

        cream.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(cream.isChecked()){
                    addins.add(getResources().getResourceEntryName(R.id.cream));
                } else{
                    addins.remove(getResources().getResourceEntryName(R.id.cream));
                }
            }
        });

        orderCoffee = (Button) view.findViewById(R.id.orderCoffee);
        orderCoffee.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                Coffee toAdd = new Coffee(currentSelectedSize, addins);
                MainActivity.menuItemList.add(toAdd);
                //toast here about order being placed
                Toast.makeText(v.getContext(), "Added to basket", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}