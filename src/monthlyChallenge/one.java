package monthlyChallenge;

public class one {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 45;

        for(int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}
