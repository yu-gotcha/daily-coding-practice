package programmers.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* 2021 카카오 채용연계형 인턴십: 거리두기 확인하기 */
public class CheckTheDistance {
    public static void main(String[] args) {
        String[][] places =
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
        int check = 0;
        for(String[] placeStr : places) {
            for (int i = 0; i < placeStr.length; i++) {
                for (int j = 0; j < placeStr[0].length(); j++) {
                    char c = placeStr[i].charAt(j);
                    if(c == 'P') {
                        if(!checkDistance(placeStr, i, j)) {
                            answer[check] = 0;
                            break;
                        }
                    }
                }
            }
            check++;
        }

        return answer;
    }

    public static boolean checkDistance(String[] place, int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[place.length][place[0].length()];
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int manhattan = Math.abs(x - nx) + Math.abs(y - ny);

                if(nx < 0 || ny < 0 || nx >= place.length || ny >= place[0].length()) continue;
                if (manhattan > 2 || visited[nx][ny]) continue;

                visited[nx][ny] = true;

                if(place[nx].charAt(ny) == 'X') continue;
                if(place[nx].charAt(ny) == 'P') return false;
                q.offer(new int[]{nx, ny});
            }
        }
        return true;
    }

}
