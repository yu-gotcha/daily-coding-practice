package programmers.hash;

import java.util.HashMap;
import java.util.Map;
/* 완주하지 못한 선수 */
public class PlayersWhoDidNotComplete {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = compareArrays(participant, completion);
        System.out.println(answer);
    }

    public static String compareArrays(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();

        for(String element : participant) participantMap.put(element, participantMap.getOrDefault(element, 0) + 1);
        for(String element : completion) participantMap.put(element, participantMap.get(element) - 1);
        for(String key : participantMap.keySet()) {
            if(!participantMap.get(key).equals(0)) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
