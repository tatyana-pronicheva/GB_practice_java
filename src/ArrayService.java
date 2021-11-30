import java.util.Scanner;

public class ArrayService {

    String[][] arr = new String[4][4];
    int sum = 0;

    public void takeArray() throws MyArraySizeException{
        System.out.println("Введите 16 элементов массива в одну строку. При окончании ввода нажмите Enter");
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        in.close();
        if (input.length != 16){
            throw new MyArraySizeException();
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = input[i*j+j];
                }
            }
        }
    }

    public void sumArray() throws MyArrayDataException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum +=Integer.parseInt(arr[i][j]);
                }
                catch (Exception e){
                    System.out.println(i);
                    System.out.println(j);
                    throw new MyArrayDataException("Неверное значение в ячейке"+i+" "+j);
                }
            }
        }

    }

}
