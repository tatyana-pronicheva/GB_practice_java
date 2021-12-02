import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet> phoneMap = new HashMap<>();

    public void add(String surname,String number){
        if (phoneMap.get(surname)==null){
            HashSet phoneSet = new HashSet();
            phoneSet.add(number);
            phoneMap.put(surname,phoneSet);
        } else{
            HashSet phoneSet = phoneMap.get(surname);
            phoneSet.add(number);
            phoneMap.put(surname,phoneSet);
        }
    };

    public void get(String surname){
        System.out.println(phoneMap.get(surname));
    };

}
