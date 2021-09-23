package programmers.sort;

import java.util.Arrays;
/* 정렬: H-Index */
public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;

        for (int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) {
                max = citations.length - i;
                break;
            }
        }

        return max;
    }
}
