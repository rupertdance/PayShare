package radance.payshare.Controller;

import android.util.Log;

import radance.payshare.Model.User;

/**
 * Created by rupertdance on 16/07/13.
 */
public class SystemManager {

    private User rupe;
    private User jess;
    private PaymentController cont;

    public SystemManager(){


    rupe = new User(0, 69, "Rupert");
    jess = new User(0, 70, "Jess");
     Log.d("test", rupe.getName());

    cont = new PaymentController();

//    cont.makeEqualPurchase(rupe, jess, 50);
//    cont.makePaymentToUser(rupe, jess, 100);


}

    public User getRupe(){
        return rupe;
    }

    public User getJess(){
        return jess;
    }

    public PaymentController getCont(){
    return cont;
    }
}
