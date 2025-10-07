public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'a';
        char smallestLetter = Character.MAX_VALUE;
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (letters[mid] < target) {
                smallestLetter = letters[mid];
            } else {
                right = mid - 1;
            }
        }
        System.out.println(smallestLetter != Character.MAX_VALUE ? smallestLetter : letters[0]);
    }
}
