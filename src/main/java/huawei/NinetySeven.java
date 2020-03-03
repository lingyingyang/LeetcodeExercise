package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 等差数列
 */
public class NinetySeven {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while ((message = br.readLine()) != null) {
            int n = Integer.parseInt(message);
            int res = n * 2 + n * (n - 1) * 3 / 2;
            System.out.println(res);
        }
    }
}
