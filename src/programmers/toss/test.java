package programmers.toss;

import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[][] v1 = {{1, 4}, {3, 4}, {3, 10}};
        int[][] v2 = {{1, 1}, {2, 2}, {1, 2}};

        System.out.println(Arrays.toString(point(v1)));
        System.out.println(Arrays.toString(point(v2)));
    }

    public static int[] point(int[][] v) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        int[] answer = new int[2];

        for(int[] p : v) {
            if(x.contains(p[0])) x.remove(Integer.valueOf(p[0]));
            else if(!x.contains(p[0])) x.add(p[0]);
            if(y.contains(p[1])) y.remove(Integer.valueOf(p[1]));
            else if(!y.contains(p[1])) y.add(p[1]);
        }

        answer[0] = x.get(0);
        answer[1] = y.get(0);

        return answer;
    }
}
