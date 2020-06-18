package com.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 简单错误记录
 */
public class Nineteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            String fileName = arr[0].substring(arr[0].lastIndexOf('\\') + 1);
            if (fileName.length() > 16) fileName = fileName.substring(fileName.length() - 16);
            String key = fileName + " " + arr[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (String key : map.keySet()) {
            if (++count <= (map.size() - 8)) break;
            System.out.println(key + " " + map.get(key));
        }
    }

}
