package interview;

import java.util.Scanner;

public class MainTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            str = str.replaceAll("[^a-zA-Z0-9\\-]", " ");
            str = str.replaceAll("[\\-]{2,}", " ");
            String[] strings = str.split("\\s+");
            for (int i = 0; i < strings.length; i++) {
                String s = strings[i];
                if (s.charAt(0) == '-') {
                    strings[i] = strings[i].substring(1);
                }
                if (s.charAt(s.length() - 1) == '-') {
                    strings[i] = strings[i].substring(0, strings[i].length() - 1);
                }
            }
            int left = 0;
            int right = strings.length - 1;
            while (left < right) {
                String tmp = strings[left];
                strings[left] = strings[right];
                strings[right] = tmp;
                left++;
                right--;
            }
            for (String s : strings) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
