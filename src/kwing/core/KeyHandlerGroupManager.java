package kwing.core;

public class KeyHandlerGroupManager {
    private static KeyHandlerGroupManager instance;
    private KeyHandlerGroup activeGroup;

    private KeyHandlerGroupManager() {
    }

    public static KeyHandlerGroupManager getInstance() {
        return instance == null ? instance = new KeyHandlerGroupManager() : instance;
    }

    public static void setActiveKeyHandlerGroup(KeyHandlerGroup g) {
        getInstance().activeGroup = g;
    }

    public static void onKeyPressed(KwingKey key) {
        KeyHandlerGroup validGroup = getInstance().activeGroup;
        if (validGroup != null) {
            validGroup.onKeyPressed(key);
        }
    }
}
