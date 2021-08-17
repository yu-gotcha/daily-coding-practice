package programmers.fullSearch;

import java.util.HashSet;
/* 완전탐색: 소수 찾기 */
public class FindPrimeNumber {
    public static void main(String[] args) {
        String numbers = "0110";

        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        String[] digits= numbers.split("");
        boolean[] visited = new boolean[digits.length];

        combinations(set, digits, "", visited);

        System.out.println(set);

        for(Integer num : set) {
            if(isPrimeNumber(num)) answer++;
        }

        return answer;
    }

    public static void combinations(HashSet<Integer> set, String[] digits, String number, boolean[] visited) {
        if(number.length() <= digits.length) {
            if(!number.equals("") && Integer.parseInt(number) != 0) set.add(Integer.parseInt(number));
        }
        else return;

        for (int i = 0; i < digits.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combinations(set, digits, number + digits[i], visited);
                visited[i] = false; // 여기서 이게 핵심임! 이거 안하면 배열 안에서 순차적인 조합밖에 없음
            }
        }
    }


    public static boolean isPrimeNumber(int number) {
        if(number == 1) return false;

        for (int i = 2; i * i <= number ; i++) {
            if(number % i == 0) return false;
        }

        return true;
    }
}
