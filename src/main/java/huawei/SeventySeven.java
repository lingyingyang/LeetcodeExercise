package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * 整形数组合并
 */
public class SeventySeven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] a = br.readLine().split(" ");
            int m = Integer.parseInt(br.readLine());
            String[] b = br.readLine().split(" ");
            TreeSet<Integer> set = new TreeSet<>();
            StringBuffer out = new StringBuffer();
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(a[i]));
            }
            for (int i = 0; i < m; i++) {
                set.add(Integer.parseInt(b[i]));
            }
            for (Integer c : set) {
                out.append(c);
            }
            System.out.println(out);
        }
    }
}
