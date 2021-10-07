package programmers.practice;

import java.util.*;
/* 압축
 * map에 <문자열, 인덱스>를 쌍으로 해서 A~Z를 넣어놓는다.
 * msg의 문자 처음부터 순회하며 다음을 실행한다.
 * msg의 [0,tmp) 까지의 부분 문자열이 map에 있다면 tmp를 증가시킨다.
 * 만약 없다면 반복문을 중단시키고 [0,tmp) 까지를 map에 등록한다.
 * 찾은 부분은 tmp-1까지이므로 tmp--를 한다.
 * 정답 리스트에  문자열 [0,tmp)의 map 값을 넣고 msg에서 해당 부분을 삭제한다.
 * */
public class Compression {
    public static void main(String[] args) {
        String msg = "KAKAO", msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println(Arrays.toString(solution(msg2)));
    }

    public static int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        int index = 27;
        StringBuilder sb = new StringBuilder(msg);

        while(sb.length() > 0) {
            int tmp = 1;
            while(tmp <= sb.length()) {
                String sub = sb.substring(0, tmp);
                if(map.containsKey(sub)) tmp++;
                else {
                    map.put(sub, index++);
                    tmp--;
                    break;
                }
            }

            if(tmp > sb.length()) tmp--;
            String str = sb.substring(0, tmp).toString();
            sb.delete(0, tmp);
            list.add(map.get(str));

        }

        return list.stream().mapToInt(a -> a).toArray();
    }

}

