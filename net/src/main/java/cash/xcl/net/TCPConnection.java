package cash.xcl.net;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.core.io.Closeable;

import java.io.IOException;
import java.nio.ByteBuffer;

public interface TCPConnection extends Closeable {
    int MAX_MESSAGE_SIZE = 1 << 20;
    int HEADER_LENGTH = 4;

    void write(Bytes<ByteBuffer> bytes) throws IOException;
}
