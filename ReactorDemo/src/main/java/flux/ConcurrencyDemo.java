package flux;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class ConcurrencyDemo {
  public static void main(String[] args) {
    List<Integer> elements = new ArrayList<>();

    Flux.just(1, 2, 3, 4)
        .log()
        .map(i -> i * 2)
        .subscribeOn(Schedulers.newParallel("parallel thread"))
        .subscribe(elements::add);
    System.out.println(elements.toString());
  }
}
