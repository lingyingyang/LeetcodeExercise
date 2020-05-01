package leetcode.string;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindrome {
    public static void main(String[] args) {
        String in = "A man, a plan, a canal: Panama";
        IsPalindrome t = new IsPalindrome();
        assertTrue(t.isPalindrome(in));
    }

    public boolean isPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char charHead = s.charAt(head);
            char charTail = s.charAt(tail);
            if (isSkip(charHead)) {
                head++;
            } else if (isSkip(charTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(charHead) != Character.toLowerCase(charTail))
                    return false;
                head++;
                tail--;
            }
        }
        return true;
    }

    private boolean isSkip(char c) {
        return !Character.isLetterOrDigit(c);
    }
}
