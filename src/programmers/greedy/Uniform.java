package programmers.greedy;

import java.util.Arrays;
/* Greedy: 체육복 */
public class Uniform {
    public static void main(String[] args) {
        int n1 = 5, n2 = 5, n3 = 3;
        int[] lost1 = {2, 4}, lost2 = {2, 4}, lost3 = {3};
        int[] reserve1 = {1, 3, 5}, reserve2 = {3}, reserve3 = {1};
        int[] lost = {}, reserve = {};

        System.out.println(solution(n1, lost1, reserve1));
        System.out.println(solution(n2, lost2, reserve2));
        System.out.println(solution(n3, lost3, reserve3));
        System.out.println(solution(n1, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 기본적으로 수업을 들을 수 있는 학생의 수

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if(reserve[i] == lost[j]) {
                    answer ++;
                    reserve[i] = lost[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if(reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]) {
                    answer ++;
                    reserve[i] = lost[j] = -1;
                }
            }
        }
        return answer;
    }
}
