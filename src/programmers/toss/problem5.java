package programmers.toss;

import java.util.*;
// 메모리 초과
public class problem5 {
    public static void main(String[] args) {
        int[] fruitWeights = {10, 50, 20, 40, 20, 30};
        int k = 3;

        System.out.println(Arrays.toString(counting(fruitWeights, k)));
    }

    public static int[] counting(int[] w, int k) {
        int[][] array = new int[1 + w.length - k][];
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b-a);
        for (int i = 0; i < 1 + w.length - k; i++) {
            array[i] = new int[k];
        }

        int idx = 0;
        for (int i = 0; i < 1 + w.length - k; i++) {
            idx = 0;
            for (int j = i; j < i + k ; j++) {
                array[i][idx++] = w[j];
            }
        }

        for (int i = 0; i < 1 + w.length - k; i++) {
            Arrays.sort(array[i]);
            set.add(array[i][k-1]);
        }

        return set.stream().mapToInt(a->a).toArray();
    }

}
