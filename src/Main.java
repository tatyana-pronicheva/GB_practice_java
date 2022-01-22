import java.lang.reflect.Array;

public class Main {
    public static void main (String[] args){

        Box<Apple>  appleBox1 = new Box<>(
                new Apple(), new Apple(), new Apple());

        Box<Apple>  appleBox2 = new Box<>(
                new Apple(), new Apple());

        Box<Orange>  orangeBox1 = new Box<>(
                new Orange(), new Orange());

        System.out.println(appleBox1.compare(orangeBox1));

        appleBox1.moveFruitsToAnotherBox(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());

        String[] array = new String[]{"a","b","c"};
        new Task1().changeElements(0,2, array);
        System.out.println(new Task2().arrayIntoArrayList(array));

    }


}
