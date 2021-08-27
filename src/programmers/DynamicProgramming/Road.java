package programmers.DynamicProgramming;

import java.util.Arrays;
/* 동적 프로그래밍: 등굣길 */
public class Road {
    public static void main(String[] args) {
        int[][] puddles = {{2,1}};
        int m = 3, n = 1;
        System.out.println(solution(m, n, puddles));
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        map[0][0] = 1;
        for(int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] != -1 && !(i == 0 && j == 0)) {
                    map[i][j] += road(map, i, j - 1) % 1000000007;
                    map[i][j] += road(map, i - 1, j) % 1000000007;
                }
            }
        }

        for(int[] element : map) System.out.println(Arrays.toString(element));

        return map[n - 1][m - 1]% 1000000007;
    }

    public static int road(int[][] map, int i, int j) {
        if(i <0 || j < 0) return 0;
        if(map[i][j] == -1) return 0;
        return  map[i][j];
    }

    
}
