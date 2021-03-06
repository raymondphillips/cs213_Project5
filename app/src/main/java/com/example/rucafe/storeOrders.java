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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link storeOrders} factory method to
 * create an instance of this fragment.
 *
 * @author Raymond Phillips, Xiaoxuan Chen
 */
public class storeOrders extends Fragment {
    private View view;
    private ListView orders;
    private final int emptyList = 0;
    private final int noSelection = -1;
    private int currentSelected = -1;
    private Button removeOrder;
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
        view = inflater.inflate(R.layout.fragment_store_orders, container, false);

        orders = (ListView) view.findViewById(R.id.storeOrders);
        List<String> ordersAsStrings = new ArrayList<>();

        for(int i = 0; i < MainActivity.orderList.size(); i++){
            ordersAsStrings.add(MainActivity.orderList.get(i).toString());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_layout, R.id.textview, ordersAsStrings
        );

        orders.setAdapter(arrayAdapter);

        removeOrder = view.findViewById(R.id.removeOrder);

        orders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * do something on item selected
             * @param parent takesn an arraylist parent
             * @param view takes a view
             * @param position takes an int position
             * @param id a long id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentSelected = position;
            }
        });

        removeOrder.setOnClickListener(new View.OnClickListener(){
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(currentSelected == noSelection){
                    //toast here about nothing seleccted
                    Toast.makeText(v.getContext(), "nothing is selected", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(ordersAsStrings.size() == emptyList){
                    //toast here about empty
                    Toast.makeText(v.getContext(), "empty basket", Toast.LENGTH_SHORT).show();
                    return;
                }

                MainActivity.orderList.remove(currentSelected);
                ordersAsStrings.remove(currentSelected);
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText(v.getContext(), "removed order", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}