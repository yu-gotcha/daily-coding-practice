package programmers.fullSearch;

import java.util.Arrays;
/* 완전 탐색: 카펫 */
public class Carpet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24, 24)));
    }

    public static int[] solution(int brown, int yellow) {
        int x, y;
        int carpetSize = brown + yellow;
        int sum = (brown + 4) / 2;
        System.out.println("xy = " + carpetSize + ", x+y = " +sum);

        for (int i = 1; i < sum; i++) {
            if(i * (sum - i) == carpetSize) return new int[] {sum - i, i};
        }

        return new int[] {-1, -1};
    }
}
