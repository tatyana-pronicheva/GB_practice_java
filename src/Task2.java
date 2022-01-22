import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Task2 <T> {
    public ArrayList<T> arrayIntoArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<>(Arrays.asList(array));
        return arrayList;
    }
}
