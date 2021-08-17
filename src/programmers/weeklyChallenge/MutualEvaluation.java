package programmers.weeklyChallenge;

/* 2주차: 상호 평가 */
public class MutualEvaluation {
    public static void main(String[] args) {
        int[][] scores1 = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
        int[][] scores2 = {{50,90},{50,87}};
        int[][] scores3 = {{70,49,90},{68,50,38}, {73,31,100}};

        System.out.println(meanScores(scores1));
        System.out.println(meanScores(scores2));
        System.out.println(meanScores(scores3));
    }

    public static String meanScores(int[][] scores) {
        int isMin, isMax, sum = 0, tmp, count = 0;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < scores.length; i++) {
            tmp = scores[i][i];
            isMax = 0;
            isMin = 0;
            sum = 0;
            count = scores.length;
            for (int[] score : scores) {
                if (tmp >= score[i]) isMax++;
                if (tmp <= score[i]) isMin++;
                sum += score[i];
            }
            if(isMax == 1 || isMin ==1) {
                sum -= tmp;
                count--;
            }
            answer.append(grade(sum / count));
        }

        return answer.toString();
    }

    public static String grade(int score) {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 50) return "D";
        else return "F";
    }
}
