public class Main {
    public static void main (String[] args){
        ArrayService arrayService = new ArrayService();
        try {
            arrayService.takeArray();
            arrayService.sumArray();
            System.out.println("Сумма элементов массива " + arrayService.sum);
        } catch(MyArraySizeException e1){
            System.out.println(e1);
        } catch (MyArrayDataException e2) {
            System.out.println(e2);
        }
    }
}
