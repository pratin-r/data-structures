import java.util.HashMap;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        /*
         * "babad contains odd length palindromic substring ("bab or
         * aba"). so this code only works for odd length palindromic substring."
         * "cbbd" contains even length palindromic substring ("bb").
         */
        String s = "babad";
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            hm.put(i, s.substring(l + 1, r));
        }
        /*
         * FOR EVEN LENGTH PALINDROMIC SUBSTRING
         * for (int i = 0; i < s.length(); i++) {
         * int l = i;
         * int r = i+1;
         * while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
         * l--;
         * r++;
         * }
         * hm.put(i, s.substring(l + 1, r));
         * }
         * 
         */
        int longestSubstringIndex = 0;
        for (Integer key : hm.keySet()) {
            if (hm.get(key).length() > longestSubstringIndex) {
                longestSubstringIndex = key;
            }
        }
        System.out.println(hm.get(longestSubstringIndex));
    }
}
