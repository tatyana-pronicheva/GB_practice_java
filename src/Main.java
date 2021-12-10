import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        //task1
        Searchable searchable = (n, list) -> {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == n) {
                    return i;
                }
            }
            return -1;
        };

        Integer[] intArray = {1, 5, 3, 6, 2, 4, 5, 7, 9, 3, 8, 6};
        System.out.println(searchable.search(3, intArray));
        System.out.println(searchable.search(11, intArray));

        //task2
        Reversable reversable = (string) -> {
            String s2 = "";
            for (int i = string.length() - 1; i >= 0; i--) {
                s2 = s2 + string.charAt(i);
            }
            return s2;
        };

        String str = "Hello World";
        System.out.println(reversable.reverse(str));

        //task3
        MaximumFinder maximumFinder = (list) -> {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.length; i++) {
                if (list[i] > max) {
                    max = list[i];
                }
            }
            return max;
        };

        System.out.println(maximumFinder.maximum(intArray));

        //task4
        AverageFinder averageFinder = (list) -> {
            double average = 0;
            for (Integer number : list) {
                average += number;
            }
            average = average / list.size();
            return average;
        };

        List<Integer> intList = Arrays.asList(intArray);
        System.out.println(averageFinder.average(intList));

        //task5
        StringFinder stringFinder = (list) -> {
            List<String> list2 = new ArrayList<>();
            for (String s : list) {
                if (s.charAt(0) == 'a' && s.length() == 3) {
                    list2.add(s);
                }
            }
            return list2;
        };

        String[] strArray = {"aaa", "BBws", "AAA", "aaaa", "43j", "a8f"};
        List<String> strList = Arrays.asList(strArray);
        System.out.println(stringFinder.search(strList));

    }
}

interface Searchable {
    public int search(Integer n, Integer[] list);
}

interface Reversable {
    public String reverse(String s);
}

interface MaximumFinder {
    public Integer maximum(Integer[] list);
}

interface AverageFinder {
    public Double average(List<Integer> list);
}

interface StringFinder {
    public List<String> search(List<String> list);
}