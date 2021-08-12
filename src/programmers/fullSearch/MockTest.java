package programmers.fullSearch;

import java.util.ArrayList;
import java.util.Arrays;
/* 모의 고사 */
public class MockTest {
    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5}, answers2 = {1,3,2,4,2};

        System.out.println(Arrays.toString(bestScore(answers1)));
        System.out.println(Arrays.toString(bestScore(answers2)));
    }

    public static int[] bestScore(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = {0, 0, 0};
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == student1[i % student1.length]) count[0] ++;
            if(answers[i] == student2[i % student2.length]) count[1] ++;
            if(answers[i] == student3[i % student3.length]) count[2] ++;
        }
        int j = 0;
        int max = Arrays.stream(count).max().orElse(0);
        for(int i = 0; i < 3; i++) {
            if(count[i] == max) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(x->x).toArray();
    }
}
