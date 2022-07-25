package romantointeger;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SolutionLeticia {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int result = romanToInt(s);
        System.out.println(result);
    }

    public static int romanToInt(String s) {
        HashMap<String, Integer> hashMap = new LinkedHashMap<>();
        hashMap.put("CM", 900);
        hashMap.put("CD", 400);
        hashMap.put("XC", 90);
        hashMap.put("XL", 40);
        hashMap.put("IX", 9);
        hashMap.put("IV", 4);

        hashMap.put("I", 1);
        hashMap.put("V", 5);
        hashMap.put("X", 10);
        hashMap.put("L", 50);
        hashMap.put("C", 100);
        hashMap.put("D", 500);
        hashMap.put("M", 1000);

        int result = 0;

        while (!s.isBlank()) {

            for (String letra : hashMap.keySet()) {
                if (s.startsWith(letra)) {
                    s = s.replaceFirst(letra, "");
                    result += hashMap.get(letra);
                }
            }
        }

        return result;
    }
}
