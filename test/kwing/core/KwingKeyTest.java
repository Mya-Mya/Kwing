package kwing.core;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class KwingKeyTest {
    @Test
    void toStringTest() {
        Arrays.stream(KwingKey.values())
                .forEach(key -> System.out.println(key.name() + " : " + key.toString()));
    }

    @Test
    void toIntegerTest() {
        Arrays.stream(KwingKey.values())
                .forEach(key -> {
                    System.out.print(key.name() + " : ");
                    try {
                        System.out.println(key.toInteger());
                    } catch (Exception e) {
                        System.out.println("Exception:" + e);
                    }
                });
    }
}