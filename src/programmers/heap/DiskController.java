package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
/* 힙: 디스크 컨트롤러 */
public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2, 6}};

        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> controller = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);

        int count = 0;
        int time = 0;
        int index = 0;
        int answer = 0;

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                controller.offer(jobs[index]);
                index++;
            }
            if(controller.isEmpty()) time = jobs[index][0];

            else {
                int[] current = controller.poll();
                answer += current[1] + time - current[0];
                time += current[1];
                count++;
            }
        }

        return (int) Math.floor((double) answer / count);
    }
}
