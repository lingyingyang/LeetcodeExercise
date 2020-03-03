package huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DNA序列
 */
public class Sixty {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dna;
        while ((dna = br.readLine()) != null) {
            int maxRadio = 0;
            int firstIdx = 0;
            int len = Integer.parseInt(br.readLine());
            for (int i = 0; i <= dna.length() - len; i++) {
                int currRatio = getCurrRatio(dna.substring(i, i + len));
                if (currRatio > maxRadio) {
                    maxRadio = currRatio;
                    firstIdx = i;
                }
            }
            System.out.println(dna.substring(firstIdx, firstIdx + len));
        }
    }

    public static int getCurrRatio(String dna) {
        int count = 0;
        for (int i = 0; i < dna.length(); i++) {
            if ('G' == dna.charAt(i) || 'C' == dna.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
