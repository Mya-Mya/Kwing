package kwing.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum KwingKey {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z,
    NUM_0,
    NUM_1,
    NUM_2,
    NUM_3,
    NUM_4,
    NUM_5,
    NUM_6,
    NUM_7,
    NUM_8,
    NUM_9,
    Enter,
    Space,
    BackSpace;

    public static Map<KwingKey, Integer> INTEGER_EXPR = new HashMap<>() {{
        put(NUM_0, 0);
        put(NUM_1, 1);
        put(NUM_2, 2);
        put(NUM_3, 3);
        put(NUM_4, 4);
        put(NUM_5, 5);
        put(NUM_6, 6);
        put(NUM_7, 7);
        put(NUM_8, 8);
        put(NUM_9, 9);
    }};

    public static Map<KwingKey, String> STRING_EXPR = new HashMap<>() {{
        List.of(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z).forEach(x -> put(x, x.name()));
        INTEGER_EXPR.forEach((key, number) -> put(key, String.valueOf(number)));
        put(Enter, "↵");
        put(Space, "␣");
        put(BackSpace, "⇤");
    }};

    @Override
    public String toString() {
        return STRING_EXPR.get(this);
    }

    public Integer toInteger() {
        if (INTEGER_EXPR.containsKey(this)) {
            return INTEGER_EXPR.get(this);
        }
        throw new IllegalArgumentException("整数表現がありません:" + this.toString());
    }
}
