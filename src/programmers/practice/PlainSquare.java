package programmers.practice;
/* 멀쩡한 사각형 */
public class PlainSquare {
    public static void main(String[] args) {
        int w = 8, h = 12;
        System.out.println(solution(w, h));
    }

    public static long solution(int w, int h) {
        long w1 = Long.parseLong(String.valueOf(w));
        long h1 = Long.parseLong(String.valueOf(h));
        long gcd = w1 < h1 ? greatestCommonDivisor(w1, h1) : greatestCommonDivisor(h1, w1);
        return w1 * h1 - (w1 + h1 - gcd);
    }

    public static long greatestCommonDivisor(long a, long b) {
        if(b == 0) return a;
        return greatestCommonDivisor(b, a%b);
    }
}
