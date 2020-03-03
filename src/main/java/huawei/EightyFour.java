package huawei;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 密码强度等级
 */
public class EightyFour {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            GetPwdSecurityLevel(line);
        }
    }

    private static void GetPwdSecurityLevel(String line) {
        int lenScore = 0;
        int numScore = 0;
        int charScore = 0;
        int otherScore = 0;
        int rewardScore = 0;

        char[] chs = line.toCharArray();
        if (chs.length <= 4)
            lenScore = 5;
        else if (chs.length <= 7)
            lenScore = 10;
        else lenScore = 25;

        int numberCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (char ch : chs) {
            if (ch >= 'a' && ch <= 'z')
                ++lowerCount;
            else if (ch >= 'A' && ch <= 'Z')
                ++upperCount;
            else if (ch >= '0' && ch <= '9')
                ++numberCount;
            else
                ++otherCount;
        }

        if (numberCount == 0)
            numScore = 0;
        else if (numberCount == 1)
            numScore = 10;
        else
            numScore = 20;

        if (lowerCount == 0 && upperCount == 0)
            charScore = 0;
        else if ((lowerCount != 0 && upperCount == 0) || (lowerCount == 0 && upperCount != 0))
            charScore = 10;
        else
            charScore = 20;

        if (otherCount == 0)
            otherScore = 0;
        else if (otherCount == 1)
            otherScore = 10;
        else
            otherScore = 25;

        if (lowerCount > 0 && upperCount > 0 && numberCount > 0 && otherCount > 0)
            rewardScore = 5;
        else if ((lowerCount > 0 || upperCount > 0) && numberCount > 0 && otherCount > 0)
            rewardScore = 3;
        else if ((lowerCount > 0 || upperCount > 0) && numberCount > 0)
            rewardScore = 2;

        int sumGriad = lenScore + numScore + charScore + otherScore + rewardScore;

        if (sumGriad >= 90)
            System.out.println("VERY_SECURE");
        else if (sumGriad >= 80)
            System.out.println("SECURE");
        else if (sumGriad >= 70)
            System.out.println("VERY_STRONG");
        else if (sumGriad >= 60)
            System.out.println("STRONG");
        else if (sumGriad >= 50)
            System.out.println("AVERAGE");
        else if (sumGriad >= 20)
            System.out.println("WEAK");
        else System.out.println("VERY_WEAK");
    }
}
