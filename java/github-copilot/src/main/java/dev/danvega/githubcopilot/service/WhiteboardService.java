package dev.danvega.githubcopilot.service;

public class WhiteboardService {

    // is palindrome?
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // method will remove any given substring from a string
    public static String removeSubstring(String str, String sub) {
        if (str == null || sub == null) {
            return str;
        }
        int len = sub.length();
        int index = str.indexOf(sub);
        if (index == -1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (index != -1) {
            sb.delete(index, index + len);
            index = str.indexOf(sub, index);
        }
        return sb.toString();
    }

    // count the number of times a substring occurs in a string
    public static int countSubstring(String str, String sub) {
        if (str == null || sub == null) {
            return 0;
        }
        int count = 0;
        int index = str.indexOf(sub);
        while (index != -1) {
            count++;
            index = str.indexOf(sub, index + sub.length());
        }
        return count;
    }

}
