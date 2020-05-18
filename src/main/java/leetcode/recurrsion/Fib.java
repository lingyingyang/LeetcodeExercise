package leetcode.recurrsion;

public class Fib {
    public static void main(String[] args) {
        int out = new Fib().fib(10);
        System.out.println(out);
    }

    /**
     * 时间复杂度O(2^n)
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0 || N == 1) return N;

        return fib(N - 1) + fib(N - 2);
    }
}
