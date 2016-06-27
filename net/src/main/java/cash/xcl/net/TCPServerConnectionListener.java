package cash.xcl.net;

import net.cangqun343.chronicle.bytes.Bytes;

public interface TCPServerConnectionListener {
    default void onNewConnection(TCPServer server, TCPConnection channel) {

    }

    default void onClosedConnection(TCPServer server, TCPConnection channel) {

    }

    default void onMessage(TCPServer server, TCPConnection channel, Bytes bytes) {

    }
}
