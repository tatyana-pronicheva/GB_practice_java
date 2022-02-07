public class ArrayService {

    public int[] modifyArray(int[] array){
        int[] modifiedArray = null;
        for (int i = array.length-1; i>=0;i--){
           if(array[i]==4){
               modifiedArray = new int[array.length-i-1];
               System.arraycopy(array, i+1, modifiedArray, 0, array.length-i-1);
               return modifiedArray;
           }
        }
        throw new RuntimeException("Входной массив не содержит четверки");
    }

    public boolean isArrayContaining4and1(int[] array){
        boolean contains1 = false;
        boolean contains4 = false;

        for (int i = 0; i<array.length; i++){
          if(array[i]==1){contains1 = true;}
          if(array[i]==4){contains4 = true;}
          if (contains1&contains4) break;
        }

        return contains1&contains4;
    }

}
