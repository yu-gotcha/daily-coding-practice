package programmers.dfsBfs;
/* 타겟 넘버 */
public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(dfs(numbers[0], 0, numbers, target));
        System.out.println(dfs((-1) * numbers[0], 0, numbers, target));
    }

    public static int dfs(int current, int index, int[] numbers, int target) {
        if(index + 1 == numbers.length) {

            if(current == target) {
                return 1;
            }
            else return 0;
        }

        return dfs(current + numbers[index + 1], index + 1, numbers, target) + dfs(current - numbers[index + 1], index + 1, numbers, target);

    }
}
