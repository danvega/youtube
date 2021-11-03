package dev.danvega.githubcopilot.utils;

public class StringUtils {

    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String upperCase(String s) {
        return s.toUpperCase();
    }
}
