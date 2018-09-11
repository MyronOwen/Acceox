package cash.xcl.api;

import net.cangqun343.chronicle.core.io.Closeable;

public interface ServerComponent extends Closeable {
    void allMessagesLookup(AllMessagesLookup lookup);
}
