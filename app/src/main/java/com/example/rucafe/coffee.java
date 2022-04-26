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
import android.widget.TextView;
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
    private TextView coffeeOutput;

    private List<String> addins;

    private final String shortSize = "short";
    private final String tallSize = "tall";
    private final String grandeSize = "grande";
    private final String ventiSize = "venti";

    private double shortPrice = 1.69;
    private double tallPrice = 2.09;
    private double grandePrice = 2.49;
    private double ventiPrice = 2.89;
    private double addonPricePer = 0.30;

    private double roundingMargin = 100.0;

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
                updateSubtotal();
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

        coffeeOutput = view.findViewById(R.id.coffeeOutput);

        whipped_cream = (CheckBox) view.findViewById(R.id.whipped_cream);
        milk = (CheckBox) view.findViewById(R.id.milk);
        caramel = (CheckBox) view.findViewById(R.id.caramel);
        syrup = (CheckBox) view.findViewById(R.id.syrup);
        cream = (CheckBox) view.findViewById(R.id.cream);

        addins = new ArrayList<String>();

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
                updateSubtotal();
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
                updateSubtotal();
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
                updateSubtotal();
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
                updateSubtotal();
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
                updateSubtotal();
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
                updateSubtotal();
            }
        });

        return view;
    }

    public void updateSubtotal(){
        double baseTotal = 0.00;
        switch(currentSelectedSize){
            case shortSize: baseTotal += shortPrice;
            break;
            case tallSize: baseTotal += tallPrice;
            break;
            case grandeSize: baseTotal += grandePrice;
            break;
            case ventiSize: baseTotal += ventiPrice;
            break;
        }

        baseTotal += addins.size() * addonPricePer;
        String toDisplay = String.format("%.2f", baseTotal);
        coffeeOutput.setText(toDisplay);
    }

}