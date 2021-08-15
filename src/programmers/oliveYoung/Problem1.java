package programmers.oliveYoung;

public class Problem1 {
    public static void main(String[] args) {
        int[] x = {3, 4}, y = {3, 5}, r = {2, 3};
        int[] v = {12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15};

        int[] x2 = {5}, y2 = {5}, r2 = {5};
        int[] v2 = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};
        System.out.println(solution(x, y, r, v));
    }

    public static int solution(int[] x, int[] y, int[] radius, int[] v) {
        //int[] top = new int[radius.length];
        //int[] bottom = new int[radius.length];
        //int[] size = new int[radius.length];
        int l = x[0] - radius[0], r = x[0] + radius[0], t = y[0] + radius[0], b = x[0] - radius[0];
        int in = 0, out = 0;

        for (int i = 0; i < radius.length; i++) {
            int left = x[i] - radius[i];
            if(l > left) l = left;

            int right = x[i] + radius[i];
            if(r < right) r = right;

            int bottom = x[i] - radius[i];
            if(b > bottom) b = bottom;

            int top = y[i] + radius[i];
            if(t < top) t = top;

        }
        System.out.println("l: " + l + ", r: " + r + ", t: " + t + ", b: " + b);

        int count = 0;
        for (int i = 0; i < v.length; i++) {
            int aa = l + (v[i++] % (r - l));
            int bb = b + (v[i] % (t - b));

            System.out.println("(a, b) : " + aa + ", " + bb);
            count = 0;
            for (int j = 0; j < radius.length; j++) {
                if (onCircle(x[j], y[j], aa, bb, radius[j])) count++;
            }
            if(count != 0) in++;
            else out++;
        }

        System.out.println("in:" + in);
        return (int) Math.floor((double) in * (r - l) * (t - b) / (in + out));
    }

    public static boolean onCircle(int x, int y, int a, int b, int r) {
        System.out.println(Math.pow(a - x, 2) + " + " + Math.pow(b - y, 2) + "=" + Math.pow(r, 2));
        boolean an = Math.pow(r, 2) >= Math.pow(a - x, 2) + Math.pow(b - y, 2);
        System.out.println(an);
        return an;
    }
}
