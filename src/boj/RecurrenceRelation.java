package boj;

import java.util.Arrays;
import java.util.Scanner;
/* 백준 13699 Silver: 점화식 */
public class RecurrenceRelation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        long[] array = new long[number + 1];

        System.out.println(recurrence(number, array));
        // System.out.println(Arrays.toString(Arrays.stream(array).toArray()));
    }

    public static long recurrence(int n, long[] array) {
        if(n == 0) return 1;
        if(array[n] > 0) return array[n];
        else {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += recurrence(i, array) * recurrence(n - 1 - i, array);
            }
            array[n] = sum;
            return sum;
        }

    }
}
