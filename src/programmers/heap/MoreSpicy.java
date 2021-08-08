package programmers.heap;

import java.util.*;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(calculateMin(scoville, K));
    }

    public static int calculateMin(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;

        for (int element : scoville) heap.offer(element);

        while(heap.peek() < K) {
            if(heap.size() == 1) return -1;

            int food1 = heap.poll();
            int food2 = heap.poll();

            heap.offer(food1 + food2 * 2);
            answer++;
        }

        return answer;
    }
}
