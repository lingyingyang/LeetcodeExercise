package com.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * MP3光标位置
 */
public class SixtyOne {
    public static String[] music(String str, int n) {
        int point = 1; // 光标
        int head = 1; // 屏幕的第一首歌
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (n <= 4) {
                if (c == 'U') {
                    if (point == head) point = n;
                    else point -= 1;
                }
                if (c == 'D') {
                    if (point == head + n - 1) point = 1;
                    else point += 1;
                }
                continue;
            }
            if (c == 'U') { // 向上
                if (point == head) { // 需要向上翻页
                    if (point == 1) { // 特殊翻页
                        point = n;
                        head = n - 3;
                    } else { // 普通翻页
                        point = point - 1;
                        head = head - 1;
                    }
                } else { // 不需要翻页
                    point -= 1;
                }
            }
            if (c == 'D') { // 向下
                if (point == head + 3) { // 需要向下翻页
                    if (point == n) { // 特殊翻页
                        point = 1;
                        head = 1;
                    } else { // 普通翻页
                        point += 1;
                        head += 1;
                    }
                } else { // 无需翻页
                    point += 1;
                }
            }
        }
        String[] strary = new String[2];
        strary[0] = head + " " + (head + 1) + " " + (head + 2) + " " + (head + 3);
        if (n <= 4) {
            strary[0] = head + "";
            for (int i = 0; i < n - 1; i++) {
                strary[0] = strary[0] + " " + (head + i + 1);
            }
        }
        strary[1] = point + "";
        return strary;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String str = br.readLine();
            System.out.println(music(str, n)[0]);
            System.out.println(music(str, n)[1]);
        }
    }
}
