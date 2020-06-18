package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 参数解析
 */
public class SeventyOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] strings = s.split(" ");
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < strings.length; ) {
            if (strings[i].charAt(0) != '"') {
                list.add(strings[i]);
                ++i;
            } else {
                if (strings[i].charAt(strings[i].length() - 1) == '"') {
                    list.add(strings[i].substring(1, strings[i].length() - 1));
                    ++i;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(strings[i].substring(1)).append(" ");
                    ++i;
                    while (strings[i].charAt(strings[i].length() - 1) != '"') {
                        sb.append(strings[i]).append(" ");
                        ++i;
                    }
                    sb.append(strings[i].substring(0, strings[i].length() - 1));
                    ++i;
                    list.add(sb.toString());
                }
            }
        }

        System.out.println(list.size());
        for (String value : list) {
            System.out.println(value);
        }
    }
}
