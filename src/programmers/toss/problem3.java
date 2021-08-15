package programmers.toss;

//테스트케이스 하나 오류났었음 -> 구분자 자리 체크하는거때문이었음 -> 해결함
public class problem3 {
    public static void main(String[] args) {
        String s = "3000,900";
        String s2 = "1000000";

        System.out.println(answer(s2));
    }

    public static boolean answer(String amount) {
        StringBuilder sb = new StringBuilder();
        int splitter = 0;

        //이걸 정규식으로 하면 더 간결해짐
        for (int i = 0; i < amount.length(); i++) {
            char c = amount.charAt(i);
            if((c >= '0' && c <= '9') || c == ',') {
                sb.append(c);
                if(c == ',') splitter++;
            }
            else return false;
        }

        if(sb.charAt(0) == '0' && sb.length() != 1) return false;
        if(sb.charAt(0) == ',' || sb.charAt(sb.length() - 1) == ',') return false;

        if(splitter == 0) return true;

        String[] splits = sb.toString().split(",");
        for (int i = 0; i < splits.length; i++) {
            if(splits[i].length() > 3) return false;
            if(i != 0 && splits[i].length() != 3) return false;
        }


        return true;
    }
}
