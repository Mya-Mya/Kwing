package kwing.core;

public class KeyHandler {
    public final KwingKey key;
    private final Runnable handler;

    public KeyHandler(KwingKey key, Runnable handler) {
        this.key = key;
        this.handler = handler;
    }

    public boolean shouldHandle(KwingKey key) {
        return this.key == key;
    }

    public boolean handleIfNeeded(KwingKey key) {
        if (shouldHandle(key)) {
            handle();
            return true;
        }
        return false;
    }

    public void handle() {
        handler.run();
    }
}
