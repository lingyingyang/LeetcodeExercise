package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 合法IP
 */
public class EightySeven {
    public static void main(String[] args) throws Exception {
        String s = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while ((s = in.readLine()) != null) {
            System.out.println(result(s));
        }
    }

    public static String result(String s) {
        String[] str = s.split("\\.");
        for (String value : str) {
            if (Integer.parseInt(value) < 0 || Integer.parseInt(value) > 255) {
                return "NO";
            }
        }
        return "YES";
    }
}
