package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FortyThree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            for (int i = 0; i < n; i++) {
                int[] repeat = new int[26];
                String s = br.readLine();
                for (int j = 0; j < s.length(); j++) {
                    repeat[s.charAt(j) - 'a']++;
                }
                Arrays.sort(repeat);
                int k = 26;
                int value = 0;
                for (int j = repeat.length - 1; j >= 0; j--) {
                    if (repeat[j] == 0) {
                        break;
                    }
                    value += repeat[j] * k;
                    k--;
                }
                System.out.println(value);
            }
        }
    }
}
