import java.util.*;

public class SecondLargestDigit {
    public static int secondHighest(String s) {
        boolean[] seen = new boolean[10];  // digits 0-9
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                seen[ch - '0'] = true;
            }
        }

        int count = 0;
        for (int i = 9; i >= 0; i--) { // start from largest
            if (seen[i]) {
                count++;
                if (count == 2) {
                    return i; // second largest
                }
            }
        }

        return -1; // no second largest digit
    }

    public static void main(String[] args) {
        String s = "dfa12321afd";
        System.out.println(secondHighest(s)); // Output: 2
    }
}
