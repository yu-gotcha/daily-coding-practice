package programmers.weeklyChallenge;

import java.util.*;
/* 6주차: 복서 정렬하기 */
// 승률 계산하고 비교할때는 단순 -로 하면 안됨! 소수점때문에
public class SortingBoxers {
    public static void main(String[] args) {
        int[] weights = {50,82,75,120}, weights2 = {145,92,86}, weights3 = {60,70,60};
        String[] head2head = {"NLWL","WNLL","LWNW","WWLN"}, head2head2 = {"NLW","WNL","LWN"}, head2head3 = {"NNN","NNN","NNN"};

        System.out.println(Arrays.toString(solution(weights, head2head)));
    }

    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        List<Boxer> list = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {
            int game = 0;
            double win = 0;
            int winMoreWeight = 0;

            for (int j = 0; j < head2head[i].length(); j++) {
                if(head2head[i].charAt(j) == 'W') {
                    win ++;
                    if(weights[i] < weights[j]) winMoreWeight ++;
                }
                if(head2head[i].charAt(j) != 'N') game++;
            }
            if(game != 0)win = (double)win/game *100;
            list.add(new Boxer(i + 1, weights[i], win, winMoreWeight));
        }

        list.sort((a, b) -> {
            if(a.win != b.win) return b.win - a.win > 0 ? 1 : -1;
            else if(a.winMoreWeight != b.winMoreWeight) return b.winMoreWeight - a.winMoreWeight;
            else if(a.weight != b.weight) return b.weight - a.weight;
            else return a.no - b.no;
        });

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).no;
        }
        return answer;
    }

    public static class Boxer {
        int no;
        int winMoreWeight;
        int weight;
        double win;

        public Boxer(int no, int weight, double win, int winMoreWeight) {
            this.no = no;
            this.weight = weight;
            this.win = win;
            this.winMoreWeight = winMoreWeight;
        }
    }
}
