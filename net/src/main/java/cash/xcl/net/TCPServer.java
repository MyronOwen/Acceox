package cash.xcl.net;

import net.cangqun343.chronicle.core.io.Closeable;

public interface TCPServer extends Closeable {
    TCPServerConnectionListener connectionListener();
}
