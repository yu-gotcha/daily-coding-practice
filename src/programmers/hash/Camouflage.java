package programmers.hash;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(caseCountWithStream(clothes1));
        System.out.println(caseCountWithStream(clothes2));
    }

    public static Integer caseCount(String[][] clothes) {
        int result = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] element : clothes) map.put(element[1], map.getOrDefault(element[1], 0) + 1);
        //System.out.println(map.toString());

        for(Integer value : map.values()) {
            result *= (value + 1);
        }

        return result - 1;
    }

    public static Integer caseCountWithStream(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(clothe -> clothe[1], mapping(clothe -> clothe[0], counting())))
                .values().stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() -1;
    }
}
