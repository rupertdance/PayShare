package radance.payshare.Model;

/**
 * Created by rupertdance on 16/07/13.
 */
public class User {

    private double balance;
    private int ID;
    private String name;

    public User(double balance, int ID, String name) {
        this.balance = balance;
        this.ID = ID;
        this.name = name;
    }

    public void changeBalance(double changeAmount){
        balance = balance + changeAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
