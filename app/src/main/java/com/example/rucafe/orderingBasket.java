package com.example.rucafe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link orderingBasket} factory method to
 * create an instance of this fragment.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class orderingBasket extends Fragment {
    private ListView items;
    private View view;
    private Button placeOrder, deleteItem;

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
        view = inflater.inflate(R.layout.fragment_ordering_basket, container, false);

        items = (ListView) view.findViewById(R.id.things_to_be_ordered);

        List<String> menuAsStrings = new ArrayList<>();
        for(int i = 0; i < MainActivity.menuItemList.size(); i++){
            menuAsStrings.add(MainActivity.menuItemList.get(i).toString());
            System.out.println(MainActivity.menuItemList.get(i).toString());
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_layout,R.id.textview, menuAsStrings);

        items.setAdapter(arrayAdapter);

        return view;

    }
}