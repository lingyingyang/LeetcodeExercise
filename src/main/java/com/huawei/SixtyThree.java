package com.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 配置文件恢复
 */
public class SixtyThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delet", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(map.getOrDefault(str, "unknown command"));
        }
    }
}
