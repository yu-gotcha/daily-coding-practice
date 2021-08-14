package programmers.practice;

public class NumericStringsAndEnglishWords {
    public static void main(String[] args) {
        String s = "23four5six7";

        System.out.println(simpleConvert(s));
    }

    public static int simpleConvert(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] digit = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(number[i], digit[i]);
        }

        return Integer.parseInt(s);
    }
    public static int convert(String s) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp >= '0' && temp <= '9') {
                answer.append(temp);
                continue;
            }
            tmp.append(s.charAt(i));

            switch (tmp.toString()) {
                case "one" : {
                    answer.append("1");
                    tmp = new StringBuilder();
                    break;
                }
                case "two" : {
                    answer.append("2");
                    tmp = new StringBuilder();
                    break;
                }
                case "three" : {
                    answer.append("3");
                    tmp = new StringBuilder();
                    break;
                }
                case "four" : {
                    answer.append("4");
                    tmp = new StringBuilder();
                    break;
                }
                case "five" : {
                    answer.append("5");
                    tmp = new StringBuilder();
                    break;
                }
                case "six" : {
                    answer.append("6");
                    tmp = new StringBuilder();
                    break;
                }
                case "seven" : {
                    answer.append("7");
                    tmp = new StringBuilder();
                    break;
                }
                case "eight" : {
                    answer.append("8");
                    tmp = new StringBuilder();
                    break;
                }
                case "nine" : {
                    answer.append("9");
                    tmp = new StringBuilder();
                    break;
                }
                case "zero" : {
                    answer.append("0");
                    tmp = new StringBuilder();
                    break;
                }
            }
        }

        return Integer.parseInt(String.valueOf(answer));
    }
}
