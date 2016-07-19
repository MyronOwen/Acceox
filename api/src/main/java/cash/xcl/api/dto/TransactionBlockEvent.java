package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.bytes.BytesStore;

public class TransactionBlockEvent extends SignedMessage {
    private final Bytes transactions = Bytes.allocateElasticDirect();
    private int weekNumber;
    private long blockNumber;

    @Override
    protected void readMarshallable2(BytesIn bytes) {
        weekNumber = bytes.readUnsignedShort();
        blockNumber = bytes.readUnsignedInt();
        transactions.clear().write((BytesStore) bytes);
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {
        bytes.writeUnsignedShort(weekNumber);
        bytes.writeUnsignedInt(blockNumber);
        bytes.write(transactions);
    }


    @Override
    protected int messageType() {
        return MethodIds.TRANSACTION_BLOCK_EVENT;
    }
}
