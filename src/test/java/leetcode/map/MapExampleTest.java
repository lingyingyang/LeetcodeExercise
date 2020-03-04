package leetcode.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MapExampleTest {
    @Test
    void name() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        log.info(map.toString());
        map.put("key", "valueTwo");
        log.info(map.toString());
        assertEquals("valueTwo", map.get("key"));
    }
}