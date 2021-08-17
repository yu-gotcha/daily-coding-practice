package programmers.weeklyChallenge;


/* 1주차: 부족한 금액 계산하기 */
public class CalculatingTheShortfall {
    public static void main(String[] args) {
        int price = 3, money = 20, count = 4;

        long answer = price * ((count * (count + 1))/2) - money;
        System.out.println(answer > 0 ? answer : 0);
    }

}
