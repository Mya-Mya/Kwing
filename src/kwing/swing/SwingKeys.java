package kwing.swing;

import kwing.core.KwingKey;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class SwingKeys {
    public static Map<Integer, KwingKey> AWT_KEYCODE_TO_KWING_KEY = new HashMap<>() {{
        put(KeyEvent.VK_A, KwingKey.A);
        put(KeyEvent.VK_B, KwingKey.B);
        put(KeyEvent.VK_C, KwingKey.C);
        put(KeyEvent.VK_D, KwingKey.D);
        put(KeyEvent.VK_E, KwingKey.E);
        put(KeyEvent.VK_F, KwingKey.F);
        put(KeyEvent.VK_G, KwingKey.G);
        put(KeyEvent.VK_H, KwingKey.H);
        put(KeyEvent.VK_I, KwingKey.I);
        put(KeyEvent.VK_J, KwingKey.J);
        put(KeyEvent.VK_K, KwingKey.K);
        put(KeyEvent.VK_L, KwingKey.L);
        put(KeyEvent.VK_M, KwingKey.M);
        put(KeyEvent.VK_N, KwingKey.N);
        put(KeyEvent.VK_O, KwingKey.O);
        put(KeyEvent.VK_P, KwingKey.P);
        put(KeyEvent.VK_Q, KwingKey.Q);
        put(KeyEvent.VK_R, KwingKey.R);
        put(KeyEvent.VK_S, KwingKey.S);
        put(KeyEvent.VK_T, KwingKey.T);
        put(KeyEvent.VK_U, KwingKey.U);
        put(KeyEvent.VK_V, KwingKey.V);
        put(KeyEvent.VK_W, KwingKey.W);
        put(KeyEvent.VK_X, KwingKey.X);
        put(KeyEvent.VK_Y, KwingKey.Y);
        put(KeyEvent.VK_Z, KwingKey.Z);
        put(KeyEvent.VK_0, KwingKey.NUM_0);
        put(KeyEvent.VK_1, KwingKey.NUM_1);
        put(KeyEvent.VK_2, KwingKey.NUM_2);
        put(KeyEvent.VK_3, KwingKey.NUM_3);
        put(KeyEvent.VK_4, KwingKey.NUM_4);
        put(KeyEvent.VK_5, KwingKey.NUM_5);
        put(KeyEvent.VK_6, KwingKey.NUM_6);
        put(KeyEvent.VK_7, KwingKey.NUM_7);
        put(KeyEvent.VK_8, KwingKey.NUM_8);
        put(KeyEvent.VK_9, KwingKey.NUM_9);
        put(KeyEvent.VK_ENTER, KwingKey.Enter);
        put(KeyEvent.VK_SPACE, KwingKey.Space);
        put(KeyEvent.VK_BACK_SPACE, KwingKey.BackSpace);
    }};


    public static KwingKey getKwingKey(int awtKeyCode) {
        if (AWT_KEYCODE_TO_KWING_KEY.containsKey(awtKeyCode)) {
            return AWT_KEYCODE_TO_KWING_KEY.get(awtKeyCode);
        }
        throw new IllegalArgumentException("このキーコードは対応していません:" + awtKeyCode);
    }
}
