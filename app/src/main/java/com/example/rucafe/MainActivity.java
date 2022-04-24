package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * the main activity class that deals with switching between the
 * different fragment views of the program.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button coffeeButton, donutButton, orderingBasketButton, storeOrderButton;

    /**
     * a method to create the fragment instance on click of the button
     * @param savedInstanceState a Bundle object of the previous savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeeButton = findViewById(R.id.coffee);
        donutButton = findViewById(R.id.donut);
        orderingBasketButton = findViewById(R.id.ordering_basket);
        storeOrderButton = findViewById(R.id.store_orders);

        Spinner spinner = findViewById(R.id.coffeeSize);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.coffeeSizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new coffee());
            }
        });

        donutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new donut());
            }
        });

        orderingBasketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new orderingBasket());
            }
        });

        storeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new storeOrders());
            }
        });


    }

    private void replaceFragment(Fragment Fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,Fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}