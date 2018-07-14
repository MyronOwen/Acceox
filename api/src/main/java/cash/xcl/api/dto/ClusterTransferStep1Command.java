package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.bytes.BytesOut;

public class ClusterTransferStep1Command extends TransferValueCommand {

    @Override
    protected void readMarshallable2(BytesIn<?> bytes) {
    }

    @Override
    protected void writeMarshallable2(BytesOut<?> bytes) {
    }

    @Override
    public int messageType() {
        return MessageTypes.CLUSTER_TRANSFER_STEP1_COMMAND;
    }
}
