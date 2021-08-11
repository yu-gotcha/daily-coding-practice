package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
/* 가장 큰 수 */
public class TheBiggestNumber {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(biggestCombination(numbers1));
        System.out.println(biggestCombination(numbers2));
    }

    public static String biggestCombination(int[] numbers) {
        ArrayList<String> list  = new ArrayList<>();
        int max = 0;
        for(int number : numbers) list.add(String.valueOf(number));

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
        if(list.get(0).equals("0")) return "0";
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
