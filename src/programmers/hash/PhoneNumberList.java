package programmers.hash;

import java.util.*;
/* 전화번호 목록 */
public class PhoneNumberList {
    public static void main(String[] args) {
        Boolean answer;
        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(checkNumberWithArrayList(phone_book1));
        System.out.println(checkNumberWithArrayList(phone_book2));
        System.out.println(checkNumberWithArrayList(phone_book3));
    }

    public static Boolean checkNumberWithArrayList(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length - 1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }

        return true;
    }

}
