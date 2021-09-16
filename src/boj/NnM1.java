package boj;

import java.util.ArrayList;
import java.util.Scanner;
/* 15649번 N과M (1) */
public class NnM1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();

        select(visited, list, n, m);

    }

    public static void select(boolean[] visited, ArrayList<Integer> list, int n, int m) {
        if(list.size() == m) {
            for (int i : list) System.out.print(i + " ");
            System.out.println();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(!visited[i - 1]) {
                list.add(i);
                visited[i - 1] = true;
                select(visited, list, n, m);
                visited[i - 1] = false;
                if(!list.isEmpty()) list.remove(list.size() - 1);
            }
        }
    }
}
