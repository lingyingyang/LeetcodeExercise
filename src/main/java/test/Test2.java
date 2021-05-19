package test;

import java.time.Duration;
import java.util.Date;

public class Test2 {
  public static void main(String[] args) {
    Date now =  new Date();
    System.out.println(now.getTime());
    Duration period = Duration.ofMillis(100L);
  }
}
