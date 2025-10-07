import java.util.HashMap;
import java.util.Map;

public class ValidPalindrome {
    /*
     * this code exceeds time in leetcode from case 480/486.
     * this happened because of using s.toLowerCase().charAt(left) or charAt(right)
     * as it takes more time compared to Character.toLowerCase().charAt(left) or
     * charAt(right)
     */
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(isPalindrome(str));
        System.out.println(Character.isAlphabetic(str.charAt(0)));
        StringBuilder str1 = new StringBuilder();
        str1.append('a');
        System.out.println(str1.indexOf("a"));
        String str2 = "12";
        // str2 += str.charAt(0);
        // System.out.println(str2);
        System.out.println(Integer.parseInt(str2));
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr.length - 1 / 2);
        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(null, null);

    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // first two while loops are only to skip anything other than alphabets
            while (left < right && !alphaNum(s.charAt(left))) {
                left++;
            }
            while (left < right && !alphaNum(s.charAt(right))) {
                right--;
            }
            // if (s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)) {
            // return false;
            // }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9');
    }
}
