package sample;

import java.util.ArrayList;

public class PersonRegister {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void addPerson(Person p){
        persons.add(p);
    }

    public Person findPerson(String pNbr){
        for(Person tmp: persons){
            if(tmp.getPnbr().equals(pNbr)){
                System.out.println("Hittade användere vid namnet: " + tmp.getName());
                return tmp;
            }
        }
        return null;
    }

    public Person findPerson2(String pNbr){
        for(Person tmp: persons){
            if(tmp.getPnbr().equals(pNbr)){
                return tmp;
            }
        }
        return null;
    }

    public Person removePerson(String pNbr){
        Person tmp = findPerson(pNbr);

        if(tmp != null){
            persons.remove(tmp);
            return tmp;

        }
        return tmp;
    }

    public ArrayList<Person> getList(){
        return persons;
    }
    public void setList(ArrayList<Person> newLista){
        persons = newLista;
    }
}

