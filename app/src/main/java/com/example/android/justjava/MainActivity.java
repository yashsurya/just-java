package com.example.android.justjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int price =0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {

        //display(quantity);
        CheckBox whippedcreamcheckbox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        Boolean haswhippedcream =whippedcreamcheckbox.isChecked();
        Log.v("MainActivity","has whipped cream"+ haswhippedcream);

        int price = calculatePrice();
        displayMessage(createordersummary(price ,quantity,haswhippedcream));
        //displayPrice(price);
    }
    public void increment(View view){
        quantity=quantity+1;
        display(quantity);
    }
    public void decrement(View view){
        quantity=quantity-1;
        display(quantity);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }

    private String createordersummary(int q ,int p ,boolean haswhip) {
        return ("NAME: Kaptain Kunak\nhas whipped cream: "+haswhip+"\n" + "Quantity:" + q + "\nTotal:" + p + "\nThankyou!");
    }

}

