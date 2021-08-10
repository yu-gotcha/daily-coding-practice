package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;
/* K번째 숫자 */
public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            answer[i] = result(array, commands[i]);
        }

    }

    public static int result(int[] array, int[] command) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if (i >= command[0] - 1 && i <= command[1] - 1) list.add(array[i]);
        }
        Collections.sort(list);

        return list.get(command[2]-1);
    }
}
