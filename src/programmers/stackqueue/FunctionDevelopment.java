package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
/* 기능 개발 */
public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> remainDays = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int j = 1, tmp;

        for(int i = 0; i < progresses.length; i++) {
            tmp = 100 - progresses[i];
            remainDays.add(tmp % speeds[i] == 0 ? tmp/speeds[i] : tmp/speeds[i] + 1);
        }

        System.out.println("RemainDays: " + remainDays);

        for(int i = 0; i < remainDays.size(); i++) {
            System.out.println("Present: " + remainDays.get(i));
            if(i + 1 ==remainDays.size()) {
                answer.add(1);
                break;
            }
            tmp = remainDays.get(i);

            j = 1;
            while(tmp >= remainDays.get(++i)) {
                System.out.println("tmp: " + tmp + ", remainDay: " + remainDays.get(i));
                j++;
                if(i + 1 ==remainDays.size()) {
                    answer.add(j);
                    return answer.stream().mapToInt(a -> a).toArray();
                }
            }
            answer.add(j);
            i--;
            System.out.println("Answer: " + answer);
        }

        System.out.println("Answer: " + answer);
        return answer.stream().mapToInt(a -> a).toArray();
    }
}
