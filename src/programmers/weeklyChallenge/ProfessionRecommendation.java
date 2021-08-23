package programmers.weeklyChallenge;

import java.util.HashMap;
/* 위클리 챌린지 4주차: 직업군 추천하기 */
public class ProfessionRecommendation {
    public static void main(String[] args) {
        String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = {"JAVA", "JAVASCRIPT"};
        int[] preference = {7, 5};

        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        HashMap<String, Integer> prefer = new HashMap<>();
        String recommend = "";
        int max = 0;

        for (int i = 0; i < languages.length; i++) {
            prefer.put(languages[i], preference[i]);
        }

        for(String element : table) {
            String[] tmp = element.split(" ");
            int sum = 0;
            for (int i = 1; i < tmp.length; i++) {
                sum += ((6 - i) * prefer.getOrDefault(tmp[i], 0));
            }
            System.out.println("직군: " + tmp[0] + ", 점수: " + sum);
            if(max <= sum) {
                if(max != sum || recommend.compareTo(tmp[0]) > 0) {
                    max = sum;
                    recommend = tmp[0];
                }
            }
        }

        return recommend;
    }
}
