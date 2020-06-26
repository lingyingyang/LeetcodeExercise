package com.leetcode;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 1, 3, 3, 2};
        int out = new Question2().findLeastNumOfUniqueInts(arr, 3);
        System.out.println(out);
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            k = k - integer;
            if (k == 0) return list.size() - 1 - i;
            else if (k < 0) return list.size() - i;
        }
        return list.size();
    }
}
