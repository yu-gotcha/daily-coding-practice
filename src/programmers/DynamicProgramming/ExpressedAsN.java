package programmers.DynamicProgramming;

import java.util.*;
/* N으로 표현 */
public class ExpressedAsN {
    public static void main(String[] args) {
        int N1 = 5, N2 = 2;
        int number1 = 12, number2 = 11;
        System.out.println(solution(N1, number1));
        System.out.println(solution(N2, number2));
    }

    public static int solution(int N, int number) {
        if(N == number) return 1;
        TreeSet<Integer>[] tree = new TreeSet[9];
        for (int i = 1; i < 9; i++) {
            tree[i] = new TreeSet<>();
        }
        tree[1].add(N);

        for(int count = 2; count < 9; count++) {
            int nn = calculateNN(count, N);
            tree[count].add(nn);
            if(nn == number) return count;

            for(int k = 1; k < count; k++) {
                Iterator<Integer> a = tree[k].iterator();
                Iterator<Integer> b = tree[count - k].iterator();

                while(a.hasNext()) {
                    int num1 = a.next();
                    HashSet<Integer> set = new HashSet<>();
                    while(b.hasNext()) {
                        int num2 = b.next();
                        set.add(num1 + num2);
                        set.add(num1 * num2);
                        set.add(num1 - num2);
                        if(num2 != 0) set.add(num1 / num2);
                    }

                    if(set.contains(number)) return count;
                    tree[count].addAll(set);
                    b = tree[count - k].iterator();
                }
            }

        }

        return -1;
    }

    public static int calculateNN(int count, int n) {
        StringBuilder nn = new StringBuilder();

        for (int i = 0; i < count; i++) {
            nn.append(n);
        }

        return Integer.parseInt(nn.toString());
    }

}
