package leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBreak {
    public static void main(String[] args) {
        boolean out = new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa"));
        assertTrue(out);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;

                String str = s.substring(j, i);
                if (words.contains(str)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
