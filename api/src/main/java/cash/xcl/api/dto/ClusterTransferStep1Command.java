package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;

public class ClusterTransferStep1Command extends TransferValueCommand {

    @Override
    protected void readMarshallable2(BytesIn bytes) {
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {
    }

    @Override
    public int messageType() {
        return MessageTypes.CLUSTER_TRANSFER_STEP1_COMMAND;
    }
}
