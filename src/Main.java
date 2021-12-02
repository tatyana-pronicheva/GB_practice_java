import java.util.*;

public class Main {
    public static void main (String[] args){

        //task1
        String[] arr = new String[]{"Арбуз","Кот","Музыка","Кот","Кот",
                "Арбуз","Мята","Кирпич","Кирпич","Мята","Снег","Музыка"};
        StringArrayService sas = new StringArrayService();
        sas.printUnique(arr);
        sas.countRepeats(arr);

        //task2
        Phonebook phonebook = new Phonebook();
        phonebook.add("Vasiliev","89405632749");
        phonebook.add("Kozlov","89405243749");
        phonebook.add("Kozlov","89562340953");
        phonebook.get("Vasiliev");
        phonebook.get("Kozlov");
    }


}

