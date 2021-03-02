package okhttp;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;

@Slf4j
public class OkHttpDemo {
  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      OkHttpClient client = new OkHttpClient.Builder().build();
      log.info(String.valueOf(client.hashCode()));
    }
  }
}
