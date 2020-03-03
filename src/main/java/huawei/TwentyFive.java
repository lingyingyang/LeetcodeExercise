package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * 数据分类处理
 */
public class TwentyFive {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String I_str = line;
            String R_str = br.readLine();
            System.out.println(fun(I_str, R_str));
        }
    }

    public static String fun(String I_str, String R_str) {
        StringBuilder result = new StringBuilder();

        String[] I = I_str.split(" ");
        String[] R = R_str.split(" ");

        Set<Integer> R_set = new TreeSet<Integer>();
        for (int i = 1; i < R.length; i++) {
            R_set.add(Integer.parseInt(R[i]));
        }

        for (int R_data : R_set) {
            int num = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < I.length; i++) {
                if (I[i].contains(String.valueOf(R_data))) {
                    num++;
                    sb.append(i - 1);
                    sb.append(" ");
                    sb.append(I[i]);
                    sb.append(" ");
                }
            }

            if (num != 0) {
                result.append(R_data);
                result.append(" ");
                result.append(num);
                result.append(" ");
                result.append(sb.toString());
            }

        }

        int all_num = result.toString().split(" ").length;

        result.insert(0, (all_num) + " ");

        return result.toString();
    }
}
