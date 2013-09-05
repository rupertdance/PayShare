package radance.payshare.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import radance.payshare.Model.User;

/**
 * Created by rupertdance on 16/07/13.
 */
public class Payment {

    private double cashAmount;
    private User to;
    private User from;
    private int paymentID;
    private String paymentName;


    Random rand = new Random();
    int min = 1000, max=99999;


//    private Calendar time; //should this be java.util or a droid specific time thingo?



    public Payment(User to, User from, double cashAmount, String paymentName) {
        this.cashAmount = cashAmount;
        this.to = to;
        this.from = from;
        this.paymentName = paymentName;
        paymentID = rand.nextInt(max - min + 1) + min;
    }


//Getters and setters

    public double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }


}
