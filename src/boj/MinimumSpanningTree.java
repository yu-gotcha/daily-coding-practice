package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int node, edge;
        node = in.nextInt();
        edge = in.nextInt();

        PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        for (int i = 0; i < edge; i++) {
            q.offer(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
        }

        int[] cycle = new int[node + 1];
        for (int i = 0; i < node + 1; i++) cycle[i] = i;

        int answer = 0;
        while(!q.isEmpty()) {
            Edge e = q.poll();

            int a = find(cycle, e.a);
            int b = find(cycle, e.b);

            if(a == b) continue;
            union(cycle, a, b);
            answer += e.value;
        }

        System.out.println(answer);
    }

    public static int find(int[] arr, int node) {
        if(node == arr[node]) return  node;
        return arr[node] = find(arr, arr[node]);
    }

    public static void union(int[] arr, int a, int b) {
        int aRoot = find(arr, a);
        int bRoot = find(arr, b);

        if(aRoot != bRoot) arr[bRoot] = aRoot;
        else return;
    }

    public static class Edge {
        int a;
        int b;
        int value;

        public Edge(int a, int b, int value) {
            this.value = value;
            this.a = a;
            this.b = b;
        }
    }

}
