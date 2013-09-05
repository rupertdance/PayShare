package radance.payshare.Controller;

import java.util.ArrayList;

import radance.payshare.Model.Payment;
import radance.payshare.Model.User;

/**
 * Created by rupertdance on 16/07/13.
 */
public class PaymentController {

    private ArrayList<Payment> payments;            //TODO make singleton?

    public PaymentController() {
        payments = new ArrayList<Payment>();
    }

    //This will only work for two people
    public void makePaymentToUser(User to, User from, double amount, String name){   //Could replace these with payment
        from.changeBalance(amount*(-1));            //TODO needs to be negative Amount
        to.changeBalance(amount);

        payments.add(new Payment(to, from, amount, name));
    }

    //This will only work for two people
    public void makeEqualPurchase(User to, User from, double amount, String name){
        //Splitting the cost 50/50
    from.changeBalance((amount/2));
    to.changeBalance((amount/2*(-1)));

    payments.add(new Payment(to, from, amount, name));

    }

    public void makePercentagePurchase(User to, User from, double amount, String name, double percentage){
        from.changeBalance(amount - (amount*percentage));
        to.changeBalance(amount + (amount*(1-percentage)));
        payments.add(new Payment(to, from, amount, name)); //TODO needs percentage I guess
    }

    public ArrayList<Payment> getPaymentsArray(){
        return payments;
    }





}
