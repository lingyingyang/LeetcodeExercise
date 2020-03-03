package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 */
public class NinetyEight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while ((message = br.readLine()) != null) {
            int n = Integer.parseInt(message);
            String[] data = br.readLine().split(" ");
            int m = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
            StringBuilder sb = new StringBuilder();
            Arrays.sort(arr);
            if (m != 0) {
                for (int i = 0; i < arr.length / 2; i++) {
                    int a = arr[i];
                    arr[i] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = a;
                }
            }
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
