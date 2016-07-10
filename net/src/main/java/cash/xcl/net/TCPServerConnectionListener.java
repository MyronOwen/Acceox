package cash.xcl.net;

import net.cangqun343.chronicle.bytes.Bytes;

import java.io.IOException;

@FunctionalInterface
public interface TCPServerConnectionListener {
    default void onNewConnection(TCPServer server, TCPConnection channel) {

    }

    default void onClosedConnection(TCPServer server, TCPConnection channel) {

    }

    void onMessage(TCPServer server, TCPConnection channel, Bytes bytes) throws IOException;
}
