package programmers.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;
/* BFS: 네트워크 */
public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    public static void bfs(int i, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int j = 0; j < computers.length; j++) {
                if(computers[current][j] == 1 && !visited[j] && i != j) {
                    q.offer(j);
                    visited[j] = true;
                }
            }
        }
    }
}
