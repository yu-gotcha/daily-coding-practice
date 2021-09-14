package boj;

import java.util.Scanner;

public class RockGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
            if(array[i] != 1) flag = true;
            else count++;
        }

        if(!flag) System.out.println(count % 2 == 0 ? "koosaga" : "cubelover");

        else {
            int result = 0;
            for (int i = 0; i < num; i++) {
                result ^= array[i];
            }

            if(count == 0) System.out.println(result != 0 ? "koosaga" : "cubelover");
            else {
                if(count % 2 == 1 && result != 0) System.out.println("koosaga");
                else if(count % 2 == 1 && result == 0) System.out.println("cubelover");
                else if(count % 2 == 0) {
                    for (int i = 0; i < num; i++) {
                        if(array[i] != 1) {
                            array[i] = 1;
                            break;
                        }
                    }

                    result = 0;

                    for (int i = 0; i < num; i++) {
                        result ^= array[i];
                    }

                    System.out.println(result != 0 ? "koosaga" : "cubelover");
                }
            }
        }
    }
}
