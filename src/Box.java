import java.util.ArrayList;
import java.util.Arrays;

public class Box <T extends Fruit>{
    ArrayList<T> fruits;

    public Box (T... fruits){
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    public double getWeight(){
        if (fruits.size()>=1){
            return fruits.size()*fruits.get(0).weight;
        }else return 0;

    };

    public boolean compare(Box<?> anotherBox){
        if (this.getWeight()==anotherBox.getWeight()){return true;}
        return false;
    }

    public void moveFruitsToAnotherBox(Box<T> anotherBox){
            anotherBox.addFruits(fruits);
            fruits.clear();
    }

    public void addFruits(ArrayList<T> fruits){
    this.fruits.addAll(fruits);
    }

}
