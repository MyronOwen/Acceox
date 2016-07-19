package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.bytes.BytesOut;
import net.cangqun343.chronicle.core.io.IORuntimeException;
import net.cangqun343.chronicle.wire.AbstractBytesMarshallable;

public class BlockRecord extends AbstractBytesMarshallable {
    long address;
    long blockNumber;
    int status;

    @Override
    public void readMarshallable(BytesIn bytes) throws IORuntimeException {
        address = bytes.readLong();
        blockNumber = bytes.readUnsignedInt();
        status = bytes.readInt();
    }

    @Override
    public void writeMarshallable(BytesOut bytes) {
        bytes.writeLong(address);
        bytes.writeUnsignedInt(blockNumber);
        bytes.writeInt(status);
    }

}
