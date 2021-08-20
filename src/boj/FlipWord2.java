package boj;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

/* 백준 17413 Silver: 단어 뒤집기 2 */
public class FlipWord2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String words = in.nextLine();

        solution(words);
    }

    public static void solution(String words) {
        boolean open = false;
        int start = 0;
        ArrayList<Word> list = new ArrayList<>();

        for (int i = 0; i < words.length(); i++) {
            if(!open && words.charAt(i) == ' ') {
                list.add(new Word(words.substring(start, i), false));
                start = i + 1;
            }
            else if(words.charAt(i) == '<') {
                if(words.charAt(i) != ' ' && i != 0 && start != i)
                    list.add(new Word(words.substring(start, i), false));
                open = true;
                start = i;
            }
            else if(words.charAt(i) == '>') {
                open = false;
                list.add(new Word(words.substring(start, i + 1), true));
                start = i + 1;
            }
            else if(i + 1 == words.length()) {
                list.add(new Word(words.substring(start, i + 1), false));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).isTag) {
                StringBuilder sb = new StringBuilder(list.get(i).str);
                list.get(i).str = sb.reverse().toString();
            }
            answer.append(list.get(i).str);

            if(i + 1< list.size() && !list.get(i).isTag && !list.get(i + 1).isTag) answer.append(" ");
        }

        //System.out.println(list.stream().map(Word::toPrint).collect(Collectors.toList()));
        System.out.println(answer.toString());
    }

    public static class Word {
        String str;
        boolean isTag;

        Word(String str, boolean isTag) {
            this.str = str;
            this.isTag = isTag;
        }

        String toPrint() {
            return this.str;
        }
    }
}
