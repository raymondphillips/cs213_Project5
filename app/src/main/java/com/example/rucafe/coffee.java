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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link coffee} factory method to
 * create an instance of this fragment.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class coffee extends Fragment{
    View view;
    String currentSelected;
    Button orderCoffee;
    CheckBox whipped_cream, milk, caramel, syrup, cream;

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
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String text = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
                currentSelected = text;
            }

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
            @Override
            public void onClick(View v) {

                for(int i =0; i < addins.size(); i++){
                    System.out.println(addins.get(i));
                }

            }
        });

        return view;
    }

}