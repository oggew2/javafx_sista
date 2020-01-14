package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;


public class Controller {

   @FXML
    private TextField PersonNamn;
   @FXML
    private TextField PersonNummer;
   @FXML
    private TextField KontoNamn;
   @FXML
    private TextArea KontoPrint;
   @FXML
   private TextField PengaRuta;
   @FXML
    private PersonRegister reg = new PersonRegister();

    @FXML
    public void AddPerson(ActionEvent evt){
        Person p = new Person();
        p.setName(PersonNamn.getText());
        p.setpNbr(PersonNummer.getText());
        String s = "Person med personnumret: " + p.getPnbr()+ " har blivit tillagd. ";
        reg.addPerson(p);
        KontoPrint.setText(s);

    }
    @FXML
    public void RemovePerson(ActionEvent evt) {
        if (reg.findPerson(PersonNummer.getText()) != null) {
            String s = ("Användaren med personnumret : " + reg.findPerson(PersonNummer.getText()).getPnbr() + "\n" + " har blivit borttagen.");
            KontoPrint.setText(s);
            reg.removePerson(PersonNummer.getText());
        } else {
            KontoPrint.setText("Kunde inte hitta någon person.");
        }
    }
    @FXML
    public void FindPerson(ActionEvent evt) {
        if (reg.findPerson2(PersonNummer.getText()) != null) {
            String s = "Hittade en person med namnet:  ";
            s += reg.findPerson2(PersonNummer.getText()).getName() + "\n";
            s += " och personnumret: " + reg.findPerson2(PersonNummer.getText()).getPnbr();
            KontoPrint.setText(s);
        }
        else {
            KontoPrint.setText("Kunde ej hitta en person med det personnumret.");
        }
    }
    @FXML
    public void AddAccount(ActionEvent evt){
       Person tmp = new Person();
        boolean HarPengar = true;
        boolean HarNamn = true;
        if(KontoNamn.getText().isEmpty()){
            HarNamn = false;
        }
        if(PengaRuta.getText().isEmpty()){
            HarPengar = false;

        }

       if(reg.findPerson2(PersonNummer.getText()) != null && HarPengar && HarNamn ) {
           tmp = reg.findPerson2(PersonNummer.getText());
           Account ac = new Account();
           tmp.addAccount(ac, KontoNamn.getText());
           ac.setBalance(Double.parseDouble(PengaRuta.getText()));
           KontoPrint.setText("Konto: "+ KontoNamn.getText()+ " har blivit tillagd.");
       }
       else{
           KontoPrint.setText("Personnummer eller summa saknas / är felaktig.");
       }
    }
    @FXML
    public void KontoPrintamannen(ActionEvent evt){
        Person tmp = new Person();
        String x = "";
        if(reg.findPerson2(PersonNummer.getText()) != null) {
            tmp = reg.findPerson2(PersonNummer.getText());
            ArrayList<Account> a = tmp.getList();
            for (int i = 0; i < a.size(); i++) {
                x+= ("Konto: " + a.get(i).getNbr());
                x +=(" har saldot: " +  a.get(i).getBalance() + "\n");
            }


            KontoPrint.setText(x);
        }
        else {
            KontoPrint.setText("Kunde ej hitta en person med det personnumret.");
        }
    }


}



