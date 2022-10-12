package ctci;

import java.util.*;

class Solution {

    /* 1.1 Is Unique: check if a string has all unique characters */
    public static boolean isUnique(String str) {

        Set<Character> map = new HashSet<>();

        for (int i=0; i<str.length(); i++) 
            if (!map.add(str.charAt(i)))
                return false;
        
        return true;
    }
    /* What if we cannot use any additional data structure? */
    public static boolean isUniqueInPlace(String str) {

        String sorted = str.chars()
                        .sorted()
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
        /* Perform a binary search */
        for (int i=0; i<sorted.length()-1; i++) {
            if (sorted.charAt(i) == sorted.charAt(i+1))
                return false;
        }
        return true;
    }

    public static void main (String[] args) {



    }




}