package google.guava;

import com.google.common.base.Preconditions;

public class PreconditionsExample {

    public static void main(String[] args) {
        PreconditionsExample test = new PreconditionsExample();

        try {
            System.out.println(test.sqrt(-3.0));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(test.sum(null, 3));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(test.getValue(6));
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public double sqrt(double input) throws IllegalArgumentException {
        Preconditions.checkArgument(input > 0.0,
                "Illegal Argument passed: Negative value %s.", input);
        return Math.sqrt(input);
    }

    public int sum(Integer a, Integer b) {
        a = Preconditions.checkNotNull(a,
                "Illegal Argument passed: First parameter is Null.");
        b = Preconditions.checkNotNull(b,
                "Illegal Argument passed: Second parameter is Null.");
        return a + b;
    }

    public int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length,
                "Illegal Argument passed: Invalid index.");
        return 0;
    }
}