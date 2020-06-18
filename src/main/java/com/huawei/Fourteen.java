package com.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 字串的连接最长路径查找
 */
public class Fourteen {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.hasNextLine() ? Integer.parseInt(sc.nextLine()) : 0;
        while (--num >= 0 && sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
