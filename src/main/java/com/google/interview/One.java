package com.google.interview;

import java.util.*;

public class One {
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        count = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        List<List<String>> out = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Map<String, List<Integer>> map = new HashMap<>();
            int itemCnt = Integer.parseInt(sc.nextLine());
            while (sc.hasNextLine()) {
                String tmp = sc.nextLine();
                if (tmp.equals("")) break;

                String[] item = tmp.split(" ");
                String name = item[0];
                int price = Integer.parseInt(item[1]);
                List<Integer> list = map.getOrDefault(name, new ArrayList<>());
                list.add(price);
                map.put(name, list);
            }

            List<String> items = new ArrayList<>();
            map.forEach((k, v) -> {
                int min = Integer.MAX_VALUE, max = 0, sum = 0, avg;
                for (int price : v) {
                    min = Math.min(price, min);
                    max = Math.max(price, max);
                    sum += price;
                }
                avg = sum / v.size();
                StringBuilder sb = new StringBuilder();
                sb.append(k).append(" ");
                sb.append(min).append(" ");
                sb.append(max).append(" ");
                sb.append(avg);
                items.add(sb.toString());
            });
            Collections.sort(items);
            out.add(items);
        }
        int idx = 1;
        for (int i = 0; i < out.size(); i++) {
            System.out.println(String.format("Case #%d:", idx++));
            out.get(i).forEach(System.out::println);
            if (i != (out.size())) System.out.println();
        }

    }
}
