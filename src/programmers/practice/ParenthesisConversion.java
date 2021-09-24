package programmers.practice;

import java.util.Stack;
/* 괄호 뒤집기 */
public class ParenthesisConversion {
    public static void main(String[] args) {
        String p = "(()())()", p2 = ")(", p3 = "()))((()";
        System.out.println(solution(p3));
    }

    public static String solution(String p) {
        return getRightStr(p);
    }

    public static String getRightStr(String p) {
        int index = splitUV(p);
        if(check(p) || p.length() == 0) return p;
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if(check(u)) return u + getRightStr(v);

        else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(getRightStr(v));
            sb.append(")");
            sb.append(reviseStr(u));

            return sb.toString();
        }
    }

    public static StringBuilder reviseStr(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 1, end = str.length() - 1;
        if(start == end) return sb;

        for(int i = 1; i < str.length() - 1; i++) {
            if(str.charAt(i) == '(') sb.append(")");
            else if(str.charAt(i) == ')') sb.append("(");
        }

        return sb;

    }

    public static int splitUV(String p) {
        int left = 0, right = 0;

        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') left ++;
            else if(p.charAt(i) == ')') right ++;
            if(right == left) return i;
        }

        return p.length() - 1;
    }

    public static boolean check(String p) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < p.length(); i++) {
            if(stack.isEmpty() && p.charAt(i) == ')') return false;
            if(p.charAt(i) == '(') stack.push(p.charAt(i));
            else if(!stack.isEmpty() && p.charAt(i) == ')') stack.pop();
        }

        return stack.isEmpty() ? true : false;
    }
}
