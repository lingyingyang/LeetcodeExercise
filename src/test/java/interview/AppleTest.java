package interview;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNull;

@Slf4j
class AppleTest {
    private HashMap<Apple, Integer> m;

    @BeforeEach
    void setUp() {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("red");

        //hashMap stores apple type and its quantity
        m = new HashMap<>();
        m.put(a1, 10);
        m.put(a2, 20);
    }

    @Test
    void whenTest_givenNoHashCode_thenNull() {
        assertNull(m.get(new Apple("green")));
    }

    @Test
    void whenTest_givenHashCode_thenReturn() {
        log.info(new Apple("green").toString());
        log.info(m.get(new Apple("green")).toString());
    }
}