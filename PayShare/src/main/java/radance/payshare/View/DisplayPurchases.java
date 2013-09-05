package radance.payshare.View;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import radance.payshare.Controller.PaymentController;

import radance.payshare.R;

/*
 * TODO: Array adapter incorporation.
 */

public class DisplayPurchases extends Activity {

    PaymentController cont = new PaymentController();
    ArrayList payments = cont.getPaymentsArray();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchases_display);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, payments);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_purchases, menu);
        return true;
    }
    
}
