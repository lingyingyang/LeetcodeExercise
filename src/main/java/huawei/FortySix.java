package huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 从单向链表中删除指定值的节点
 */
public class FortySix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            handle(scanner);
        }
        scanner.close();
    }

    public static void handle(Scanner scanner) {
        String str = scanner.nextLine();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int loc = str.indexOf(" ");
        int num = Integer.parseInt(str.substring(0, loc));
        str = str.substring(loc + 1);
        loc = str.indexOf(" ");
        linkedList.add(Integer.parseInt(str.substring(0, loc)));
        str = str.substring(loc + 1);
        int start, end;
        end = -1;
        for (int i = 0; i < num - 1; i++) {
            start = end + 1;
            int loc1 = str.indexOf(" ", start);
            end = str.indexOf(" ", loc1 + 1);
            int node = Integer.parseInt(str.substring(start, loc1));
            int after = Integer.parseInt(str.substring(loc1 + 1, end));
            int location = linkedList.indexOf(after);
            linkedList.add(location + 1, node);
        }
        int deleteData = Integer.parseInt(str.substring(end + 1));
        linkedList.remove(new Integer(deleteData));
        for (Integer integer : linkedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
