package com.example.rucafe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import cafe.Order;

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
    private final int emptyList = 0;
    private final int noSelection = -1;
    private int currentSelected = -1;

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
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_layout, R.id.textview, menuAsStrings);

        items.setAdapter(arrayAdapter);

        placeOrder = view.findViewById(R.id.placeOrder);
        deleteItem = view.findViewById(R.id.deleteMenuItem);

        items.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSelected = position;
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menuAsStrings.size() == emptyList){
                    //toast here about empty
                    return;
                }

                int orderId;
                if(MainActivity.orderList.size() == emptyList){
                    orderId = 0;
                } else{
                    orderId = MainActivity.orderList.get(MainActivity.orderList.size()-1).orderNum + 1;
                }
                Order order = new Order(orderId);
                for(int i = 0; i < MainActivity.menuItemList.size(); i++){
                    order.items.add(MainActivity.menuItemList.get(i));
                }
                MainActivity.orderList.add(order);
                MainActivity.menuItemList.clear();
                menuAsStrings.clear();
                arrayAdapter.notifyDataSetChanged();
                //toast here about successful order
            }
        });

        deleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menuAsStrings.size() == 0){
                    //toast here about empty
                    return;
                }

                if(currentSelected == noSelection){
                    //toast here about nothing selected
                    return;
                }

                MainActivity.menuItemList.remove(currentSelected);
                menuAsStrings.remove(currentSelected);
                arrayAdapter.notifyDataSetChanged();
                //toast here about successful deletion
            }
        });

        return view;

    }
}