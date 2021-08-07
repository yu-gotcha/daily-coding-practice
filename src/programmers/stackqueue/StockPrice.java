package programmers.stackqueue;

import java.util.*;
/* 주식 가격 */
public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solutionWithStack(prices)));
    }

    public static int[] solutionWithStack(int[] prices) {
        int[] seconds = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i< prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int top = stack.pop();
                seconds[top] = i - top;
                System.out.println("stack: " + stack + ", seconds: " + Arrays.toString(seconds));
            }
            stack.push(i);
        }
        int size = prices.length;
        while(!stack.isEmpty()) {
            int top = stack.pop();
            seconds[top] = size - 1 - top;
        }

        return seconds;
    }


    // 효율성 통과 못함함 - 차라리 이중 for 문으로 단순배열 이용하는게 더 효율성 높음
   public static int[] solution(int[] prices) {
        ArrayList<Integer> stocks = new ArrayList<>();
        ArrayList<Integer> seconds = new ArrayList<>();
        int tmp, second = 0;

        for(Integer price : prices) stocks.add(price);

        while(!stocks.isEmpty()) {
            tmp = stocks.remove(0);
            second = 1;

            for(int i = 0; i < stocks.size(); i++) {
                System.out.println("tmp: " + tmp + ", stock:" + stocks.get(i));
                if(tmp > stocks.get(i) || i == stocks.size() - 1) {
                    seconds.add(second);
                    break;
                }
                second++;
            }
        }
        seconds.add(0);

        return seconds.stream().mapToInt(a -> a).toArray();
    }
}
