public class HomeWorkApp {
    public static void main(String[] args) {
    task6();
    }

    public static void task1(){
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i]==0){
                arr[i]=1;
            } else if (arr[i]==1){
                arr[i]=0;
            }
            System.out.println(arr[i]);
        }
    }

    public static void task2(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++){
            arr[i]=i+1;
            System.out.println(arr[i]);
        }
    }

    public static void task3(){
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++){
            if (arr[i]<6){
                arr[i]*=2;
            }
            System.out.println(arr[i]);
        }
    }

    public static void task4(){
        int[][] arr = {{0,0,0,0,0},
                       {0,0,0,0,0},
                       {0,0,0,0,0},
                       {0,0,0,0,0},
                       {0,0,0,0,0}};

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i==j){
                    arr[i][j]=1;
                }
                if (i==arr.length-j-1){
                    arr[i][j]=1;
                }
            }
        }
        //вывод массива
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println("");
        }
    }

    public static int[] task5(int len, int initialValue){
        int[] arr = new int[len];
        for (int i=0; i<len; i++){
            arr[i]=initialValue;
        }
        return arr;
    }

    public static void task6(){
        int max = -2147483648;
        int min = 2147483647;
        int[] arr = {3,6,8,3,2,0,3,5,8,9,3};
        for (int i=0; i<arr.length; i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("Минимальное число "+min);
        System.out.println("Максимальное число "+max);
    }
}
