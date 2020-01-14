package sample;

public class Account {
    private String nbr;
    private double balance;
    private Person owner;


    public void setOwner(Person p){
        p = owner;
    }
    public Person getOwner(){
        return owner;
    }

    public void setNbr(String nb){
        nbr = nb;
    }
    public String getNbr(){
        return nbr;
    }


    public void setBalance(double amount){
        balance = amount;
    }
    public double getBalance(){
        return balance;
    }
    public void credit(double amount){
        balance += amount;

    }
    public void withdraw(double amount){
        balance -= amount;
    }

}
