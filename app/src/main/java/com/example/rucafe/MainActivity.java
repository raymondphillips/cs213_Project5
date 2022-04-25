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

import java.util.ArrayList;
import java.util.List;

import cafe.MenuItem;
import cafe.Order;

/**
 * the main activity class that deals with switching between the
 * different fragment views of the program.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class MainActivity extends AppCompatActivity  {

    public static int donutPosition;
    Button coffeeButton, donutButton, orderingBasketButton, storeOrderButton;
    public static List<MenuItem> menuItemList = new ArrayList<>();
    public static List<Order> orderList = new ArrayList<>();

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


}