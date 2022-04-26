package com.example.rucafe;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView orderingBasketSubtotal;
    private double njTax = 0.06625;

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
            menuAsStrings.add("$" + MainActivity.menuItemList.get(i).itemPrice() + " - " + MainActivity.menuItemList.get(i).toString());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_layout, R.id.textview, menuAsStrings);

        items.setAdapter(arrayAdapter);

        placeOrder = view.findViewById(R.id.placeOrder);
        deleteItem = view.findViewById(R.id.deleteMenuItem);
        orderingBasketSubtotal = view.findViewById(R.id.orderingBasketSubtotal);

        updateCosts();

        items.setOnItemClickListener(new AdapterView.OnItemClickListener(){
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

        placeOrder.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(menuAsStrings.size() == emptyList){
                    //toast here about empty
                    Toast.makeText(v.getContext(), "empty basket", Toast.LENGTH_SHORT).show();
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
                updateCosts();
                //toast here about successful order
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Your order has been placed");
                alert.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(v.getContext(), "order placed successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }
        });

        deleteItem.setOnClickListener(new View.OnClickListener() {
            /**
             * a method to do something when clicked on
             * @param v takes in a view
             */
            @Override
            public void onClick(View v) {
                if(menuAsStrings.size() == 0){
                    //toast here about empty
                    Toast.makeText(v.getContext(), "empty basket", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(currentSelected == noSelection){
                    //toast here about nothing selected
                    Toast.makeText(v.getContext(), "nothing is selected", Toast.LENGTH_SHORT).show();
                    return;
                }

                MainActivity.menuItemList.remove(currentSelected);
                menuAsStrings.remove(currentSelected);
                arrayAdapter.notifyDataSetChanged();
                updateCosts();
                //toast here about successful deletion
                Toast.makeText(v.getContext(), "successfully deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
    /**
     * a method to update the costs
     */
    public void updateCosts(){
        double price = 0.00;
        for(int i = 0; i < MainActivity.menuItemList.size(); i++){
            price += MainActivity.menuItemList.get(i).itemPrice();
        }

        String toDisplay = "Subtotal " + String.format("%.2f", price);
        toDisplay += "\nTax (NJ): ";
        double taxed = price * njTax;
        toDisplay += String.format("%.2f", taxed);
        toDisplay += "\nTotal: ";

        double priceTaxed = price + taxed;
        toDisplay += String.format("%.2f", priceTaxed);
        orderingBasketSubtotal.setText(toDisplay);

    }
}