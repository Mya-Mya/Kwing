package kwing.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KeyHandlerGroup {
    private final List<KeyHandler> mKeyHandlerList;

    public KeyHandlerGroup(List<KeyHandler> mKeyHandlerList) {
        this.mKeyHandlerList = new ArrayList<>();
        mKeyHandlerList.forEach(this::addKeyHandler);
    }

    public KeyHandlerGroup() {
        this(Collections.EMPTY_LIST);
    }

    public void addKeyHandler(KeyHandler mKeyHandler) {
        if (mKeyHandlerList.stream().anyMatch(x -> x.key == mKeyHandler.key)) {
            throw new IllegalArgumentException("同じキーハンドラーグループ内で同じキーを2回以上登録することはできません。");
        }
        mKeyHandlerList.add(mKeyHandler);
    }

    public void onKeyPressed(KwingKey key) {
        mKeyHandlerList.forEach(mKeyHandler -> mKeyHandler.handleIfNeeded(key));
    }
}
