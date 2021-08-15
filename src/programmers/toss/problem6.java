package programmers.toss;

import java.util.Arrays;

public class problem6 {
    public static void main(String[] args) {
        int numOfStairs = 4;
        System.out.println(counting(numOfStairs));
    }

    public static long counting(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return counting(n, memo);
    }

    public static long counting(int n, long[] memo) {
        System.out.println("n: " + n + ", " + Arrays.toString(Arrays.stream(memo).toArray()));
        if(n < 0) return 0;
        else if(n == 0) return 1;
        else if(memo[n] > -1) return memo[n];
        else{
            memo[n] = counting(n - 1, memo) + counting(n - 2, memo) + counting(n - 3, memo);
            return memo[n];
        }
    }
}
