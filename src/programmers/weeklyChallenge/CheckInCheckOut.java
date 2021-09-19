package programmers.weeklyChallenge;

import java.util.*;
/* 7주차: 입실 퇴실 */
public class CheckInCheckOut {
    public static void main(String[] args) {
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,4,3};

        System.out.println(Arrays.toString(solution(enter, leave)));
    }

    /*
    * 사람을 차례대로 입실시킴
    * 입실 한 후 방에 있는 사람만큼(본인 제외) 만난 횟수를 지정
    * 이미 들어와있던 사람에 대해서는 +1 해줌
    * 입시한 사람중에 퇴실할 사람이 있으면 해당 사람 빼줌
    * 퇴실 순서대로 하되 더이상 퇴실할 사람이 없을때까지 퇴실 진행함
    * 모두가 입실 & 퇴실하면 끝
    */
    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;

        for(int person : enter) {
            q.offer(person);
            for(int element : q) {
                if(map.containsKey(element)) map.put(element, map.get(element) + 1);
                else map.put(element, q.size() - 1);
            }

            while(i < leave.length && q.contains(leave[i])) {
                answer[leave[i] - 1] = map.get(leave[i]);
                q.remove(leave[i]);
                i++;
            }

        }
        return answer;
    }
}
