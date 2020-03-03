package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 字符串加密
 */
public class ThirtySix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sr = "";
        while ((sr = br.readLine()) != null) {
            StringBuilder bu = new StringBuilder();
            String sr1 = br.readLine();
            HashSet<Character> set = new LinkedHashSet<>();
            for (int i = 0; i < sr.length(); i++)
                set.add(sr.charAt(i));
            for (int i = 0; i < 26; i++)
                set.add((char) (i + 'a'));
            char[] ch = new char[set.size()];
            Iterator<Character> iter = set.iterator();
            for (int i = 0; i < ch.length && iter.hasNext(); i++)
                ch[i] = iter.next();
            for (int i = 0; i < sr1.length(); i++) {
                if (Character.isLowerCase(sr1.charAt(i)))
                    bu.append(Character.toLowerCase(ch[sr1.charAt(i) - 'a']));
                else
                    bu.append(Character.toUpperCase(ch[sr1.charAt(i) - 'A']));
            }
            System.out.println(bu);
        }
    }
}
