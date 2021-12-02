import java.util.HashSet;

public class StringArrayService {
    public void printUnique(String[] arr){
        HashSet hs = new HashSet();
        for (int i = 0; i<arr.length;i++){
            hs.add(arr[i]);
        }
        System.out.println(hs);
    }

    public void countRepeats(String[] arr) {
        int count;
        HashSet hs = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }
        for(Object o : hs){
            count = 0;
            for (int i = 0; i<arr.length; i++){
                if(arr[i] == o.toString()){
                    count +=1;
                }
            }
            System.out.println(o + " встречается " + count);
        }

    }
}
