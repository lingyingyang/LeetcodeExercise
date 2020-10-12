package leetcode.mapset.map;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Logger {
    public static void main(String[] args) {
        Logger logger = new Logger();

        // 日志内容 "foo" 在时刻 1 到达系统
        assertTrue(logger.shouldPrintMessage(1, "foo"));

        // 日志内容 "bar" 在时刻 2 到达系统
        assertTrue(logger.shouldPrintMessage(2, "bar"));

        // 日志内容 "foo" 在时刻 3 到达系统
        assertFalse(logger.shouldPrintMessage(3, "foo"));

        // 日志内容 "bar" 在时刻 8 到达系统
        assertFalse(logger.shouldPrintMessage(8, "bar"));

        // 日志内容 "foo" 在时刻 10 到达系统
        assertFalse(logger.shouldPrintMessage(10, "foo"));

        // 日志内容 "foo" 在时刻 11 到达系统
        assertTrue(logger.shouldPrintMessage(11, "foo"));
    }

    Map<String, Integer> cache;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        this.cache = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed. The timestamp is in seconds
     * granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!cache.containsKey(message)) {
            cache.put(message, timestamp);
            return true;
        } else if (cache.get(message) <= (timestamp - 10)) {
            cache.put(message, timestamp);
            return true;
        }
        return false;
    }
}
