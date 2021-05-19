package flux;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/** Hot Stream demo */
public class ConnectableFluxDemo {
  public static void main(String[] args) {
    ConnectableFlux<Object> publish =
        Flux.create(
                fluxSink -> {
                  while (true) {
                    fluxSink.next(System.currentTimeMillis());
                  }
                })
            .log()
            .sample(Duration.ofSeconds(2)) // throttling example: interval
            .publish();

    publish.subscribeOn(Schedulers.newParallel("parallel-thread"))
               .subscribe(System.out::println);

    publish.connect();
  }
}
