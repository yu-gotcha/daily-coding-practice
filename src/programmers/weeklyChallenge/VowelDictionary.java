package programmers.weeklyChallenge;
/* 5주차: 모음사전 */
public class VowelDictionary {
    public static void main(String[] args) {
        String word = "EIO";

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        String[] spelling = word.split("");
        int[] unit = new int[5];
        unit[4] = 1;
        for (int i = 3; i >= 0; i--) {
            unit[i] = unit[i + 1] * 5 + 1;
        }
        int answer = 0;
        for (int i = 0; i < spelling.length; i++) {
            switch (spelling[i]) {
                case "A" : answer += 1; break;
                case "E" : answer += unit[i] * 1 + 1; break;
                case "I" : answer += unit[i] * 2 + 1; break;
                case "O" : answer += unit[i] * 3 + 1; break;
                case "U" : answer += unit[i] * 4 + 1; break;
            }
        }

        return answer;
    }
}
