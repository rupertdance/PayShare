package radance.payshare.View;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import radance.payshare.Controller.SystemManager;
import radance.payshare.R;

public class MainActivity extends Activity {

    SystemManager sys = new SystemManager();    //when does this run?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setBalances();

        configureOnClickListeners();

    }


    private void configureOnClickListeners() {
        Button rupePurchaseButton = (Button) findViewById(R.id.rupePurchase);
        rupePurchaseButton.setOnClickListener(new View.OnClickListener() { //this...View. ?
            public void onClick(View v) {
                calculateRupe();

            }
        });

        Button jessPurchaseButton = (Button) findViewById(R.id.jessPurchase);
        jessPurchaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateJess();
            }
        });

        Button previousPurchases = (Button) findViewById(R.id.previousPurchasesButton);
        previousPurchases.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                previousPurchaseLaunch();
            }
        });

    }

    private void previousPurchaseLaunch() {
        Intent newIntent = new Intent(this, DisplayPurchases.class);
        startActivity(newIntent);
        //launch intent into new activity with list adapter etc here
    }

    public void calculateRupe(){
        EditText rupeEdit = (EditText) findViewById(R.id.rupeEditText); //page would do these separately
        String cashAmount = rupeEdit.getText().toString();
        Double value = Double.parseDouble(cashAmount);

        //getting expenditure name
        EditText boughtEdit = (EditText) findViewById(R.id.rupeBoughtName);
        String name = boughtEdit.getText().toString();  //apparently correct?

        sys.getCont().makeEqualPurchase(sys.getJess(), sys.getRupe(), value, name);

        //updating balance
        setBalances();

        //clearing fields
        rupeEdit.setText("");
        boughtEdit.setText("");

        Toast.makeText(this, "Payment Calculated Successfully", Toast.LENGTH_SHORT).show();

    }

    public void calculateJess(){
        EditText jessEdit = (EditText) findViewById(R.id.jessEditText); //page would do these separately
        String cashAmount = jessEdit.getText().toString();
        Double value = Double.parseDouble(cashAmount);

        //getting expenditure name
        EditText boughtEdit = (EditText) findViewById(R.id.jessBoughtName);
        String name = boughtEdit.getText().toString();


        sys.getCont().makeEqualPurchase(sys.getRupe(), sys.getJess(), value, name);

        //updating balance
        setBalances();

        //clearing fields
        jessEdit.setText("");
        boughtEdit.setText("");

        Toast.makeText(this, "Payment Calculated Successfully", Toast.LENGTH_SHORT).show();

    }


    private void setBalances() {


        TextView rupeText = (TextView) findViewById(R.id.rupeCash);
        double temp =  sys.getRupe().getBalance();
        String temp2 = String.valueOf(temp);
        rupeText.setText(temp2);

        TextView jessText = (TextView) findViewById(R.id.jessCash);
        temp =  sys.getJess().getBalance();
        temp2 = String.valueOf(temp);
        jessText.setText(temp2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    
}
