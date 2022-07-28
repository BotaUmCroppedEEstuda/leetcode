package validanagram;

import java.util.Arrays;

public class SolutionLeticia {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);

        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return String.valueOf(sChar).equals(String.valueOf(tChar));
    }
}
