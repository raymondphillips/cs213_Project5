package com.example.rucafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * the main activity class that deals with swithching between the
 * different fragment views of the program.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class MainActivity extends AppCompatActivity {
    /**
     * a method to create the fragment instance on click of the button
     * @param savedInstanceState a Bundle object of the previous savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}