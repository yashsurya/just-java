package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price =0;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submitOrder(View view) {

        //display(quantity);
        EditText noc =(EditText) findViewById(R.id.quantity_text_view) ;
        String c =noc.getText().toString();
        quantity =Integer.parseInt(c);

        EditText text =(EditText) findViewById(R.id.name) ;
        String username =text.getText().toString();
        Log.v("MainActivity","Name"+username);

        CheckBox whippedcreamcheckbox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        Boolean haswhippedcream =whippedcreamcheckbox.isChecked();
        CheckBox Chocolatecheckbox =(CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean haschocolate =Chocolatecheckbox.isChecked();

        int price = calculatePrice();
        displayMessage(createordersummary(username,price ,quantity,haswhippedcream,haschocolate));
        //displayPrice(price);
    }
    public void increment(View view){
        if (quantity<100)
        {quantity=quantity+1;
            display(quantity);}
        else
        {display(quantity);}}
    public void decrement(View view){
        if (quantity>0)
        {quantity=quantity-1;
            display(quantity);}
        else
        {display(quantity);}
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

    private String createordersummary(String username,int q ,int p ,boolean haswhip,boolean haschoc) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "yashsurya1105@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "nothing");
        intent.putExtra(Intent.EXTRA_TEXT, ("NAME: "+username+"\n whipped cream: "+haswhip+"\nhas chocolate: "+haschoc+"\n" + "Quantity:" + q + "\nTotal:" + p + "\nThankyou!"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        return ("NAME: "+username+"\n whipped cream: "+haswhip+"\nhas chocolate: "+haschoc+"\n" + "Quantity:" + q + "\nTotal:" + p + "\nThankyou!");
    }

}

