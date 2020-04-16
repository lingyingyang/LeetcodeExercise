package google.interview;

public class RepeatedStringMatch {
    public static void main(String[] args) {
        String A = "abcd";
        String B = "cdabcdab";
        RepeatedStringMatch test = new RepeatedStringMatch();
        int out = test.repeatedStringMatch(A, B);
        System.out.println(out);
    }

    public int repeatedStringMatch(String A, String B) {
        StringBuilder temp = new StringBuilder(A);
        int ans = 1;
        while (temp.length() < B.length()) {
            temp.append(A);
            ans++;
        }

        if (temp.toString().contains(B)) return ans;
        else {
            temp.append(A);
            ans++;
            if (temp.toString().contains(B)) return ans;
            else return -1;
        }
    }
}
