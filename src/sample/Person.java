package sample;

import java.util.ArrayList;

public class Person {
    private String pNbr;
    private String name;

    ArrayList<Account> konton = new ArrayList<Account>();


    public void setpNbr(String pn) {
        pNbr = pn;
    }

    public String getPnbr() {
        return pNbr;
    }

    public void setName(String na) {
        name = na;
    }

    public String getName() {
        return name;
    }

    public void addAccount() {
        Account konto = new Account();
        konton.add(konto);

    }

    public ArrayList<Account> getList() {
        return konton;
    }

    public void setList(ArrayList<Account> newLista) {
        konton = newLista;
    }

    public void addAccount(Account a, String nbr) {
        a.setNbr(nbr);
        konton.add(a);
    }

}
