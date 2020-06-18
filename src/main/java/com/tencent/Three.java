package com.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        int[] people = new int[num];
        int[] ans = new int[num];
        String[] arr = in.nextLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            people[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(people);
        int left = 0;
        int right = num - 1;
        for (int i = 0; i < people.length; i++) {
            int person = people[i];
            if (i % 2 == 0) {
                ans[left++] = person;
            } else {
                ans[right--] = person;
            }
        }

        for (int item : ans) {
            System.out.print(item + " ");
        }
    }
}
