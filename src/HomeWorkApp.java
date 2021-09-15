public class HomeWorkApp {

    public static void main (String[] args){
        System.out.println(isSumBetween10And20(12,2));
        positiveOrNegativeNumber(-1);
        System.out.println(isNumberNegative(-5));
        printStringXTimes("Привет",7);
    }

    private static boolean isSumBetween10And20(int a,int b){
        int sum=a+b;
        if (sum>=10 && sum<=20){return true;} else {return false;}
    }
    private static void positiveOrNegativeNumber(int a){
        if (a>=0){System.out.println("Число "+a+" положительное");
        } else {System.out.println("Число "+a+" отрицательное");
    }}
    private static boolean isNumberNegative(int a){
        if (a<0){return true;} else {return false;}
    }

    private static void printStringXTimes(String s, int x){
        for (int i=0;i<x;i++){
            System.out.println(s);
        }
    }
}
