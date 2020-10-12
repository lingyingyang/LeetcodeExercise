package hash;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

public class HashMD5Example {
    public static String byteArrayToString(byte[] b) {
        StringBuilder ans = new StringBuilder();
        for (byte value : b) {
            ans.append(byteToNumString(value));
        }
        return ans.toString();
    }

    private static String byteToNumString(byte b) {
        int tmp = b;
        if (tmp < 0) {
            tmp = 256 + tmp;
        }
        return String.valueOf(tmp);
    }

    public static String MD5Encode(String origin) {
        String ans = null;
        try {
            ans = origin;
            //            MessageDigest md = MessageDigest.getInstance("MD5");
            //            ans = byteArrayToString(md.digest(ans.getBytes()));
            MessageDigest md = DigestUtils.getMd5Digest();
            ans = byteArrayToString(md.digest(ans.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    public static void main(String[] args) {
        String url = "http://127.0.0.1/home";
        System.out.println(MD5Encode(MD5Encode(url)));
    }
}
