package leetcode.recurrsion;

public class StackSize {
    public static void main(String[] args) {
        StackSize t = new StackSize();
        try {
            t.cal();
        } catch (Throwable e) {
            System.out.println(t.size);
            throw e;
        }
    }

    private int size = 0;

    public void cal() {
        size++;
        cal();
    }
}
