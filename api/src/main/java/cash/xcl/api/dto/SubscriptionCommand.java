package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;

public class SubscriptionCommand extends SignedMessage {
    @Override
    protected void readMarshallable2(BytesIn bytes) {

    }

    @Override
    protected int messageType() {
        return MethodIds.SUBSCRIPTION_COMMAND;
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {

    }
}
