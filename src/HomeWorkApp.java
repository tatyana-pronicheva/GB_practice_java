public class HomeWorkApp {
    public static void main(String[] args){
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    private static void checkSumSign(){
        int a=-2;
        int b=0;
        int sum=a+b;
        if (sum>=0){
            System.out.println("Сумма положительная");
        }else {System.out.println("Сумма отрицательная");}
    }
    private static void printColor(){
        int value=100;
        if (value<=0){System.out.println("Красный");}
        if (value>0 && value<=100){System.out.println("Желтый");}
        if (value>100){System.out.println("Зеленый");}
    }
    private static void compareNumbers(){
        int a=100;
        int b=87;
        if (a>=b){System.out.println("a >= b");} else {System.out.println("a < b");}
    }
}
