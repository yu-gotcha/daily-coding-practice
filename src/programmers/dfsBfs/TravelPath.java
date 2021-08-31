package programmers.dfsBfs;

import java.util.*;
/* DFS/BFS: 여행경로 */
public class TravelPath {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(solution(tickets2)));
    }

    public static String[] solution(String[][] tickets) {
        ArrayList<String> list = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];

        dfs("ICN", "ICN", tickets, visited, 0, list);
        Collections.sort(list);
        for(String element : list) System.out.println(element);
        return list.get(0).split(" ");
    }

    public static void dfs(String answer, String current, String[][] tickets, boolean[] visited, int count, ArrayList<String> list) {
        if(count == tickets.length) {
            list.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(answer + " " +tickets[i][1], tickets[i][1], tickets, visited, count + 1, list);
                visited[i] = false;
            }
        }
    }

}

/*
public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        HashMap<String, TreeSet<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                TreeSet<String> tmp = new TreeSet<>(String::compareTo);
                tmp.add(ticket[1]);
                map.put(ticket[0], tmp);
            }
            else map.get(ticket[0]).add(ticket[1]);
        }

        String destination = "";
        for (int i = 0; i < tickets.length + 1; i++) {
            System.out.println("Destination: " + destination);
            if(i == 0) {
                answer[i] = "ICN";
                destination = map.get("ICN").pollFirst();
                continue;
            }
            answer[i] = destination;
            if(i < tickets.length) destination = map.get(destination).pollFirst();
        }
        return answer;
    }
 */
