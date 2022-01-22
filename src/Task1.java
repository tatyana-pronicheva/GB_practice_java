public class Task1<T> {
    public T[] changeElements(int index1, int index2, T[] array){
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }
}
