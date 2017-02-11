package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;

public class DepositValueInformationEvent extends SignedMessage {

    // TODO
    //private DepositValueCommand tvc;
    private Transfer transfer;

    public DepositValueInformationEvent(long sourceAddress, long eventTime, Transfer transfer) {
        super(sourceAddress, eventTime);
        this.transfer = transfer;
    }


    public DepositValueInformationEvent() {
        super();
    }

    @Override
    protected void readMarshallable2(BytesIn bytes) {
        transfer.doReadMarshallable(bytes);
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {
        transfer.doWriteMarshallable(bytes);
    }

    @Override
    protected int messageType() {
        return MethodIds.DEPOSIT_INFORMATION_EVENT;
    }


    public Transfer transfer() {
        return transfer;
    }

    public DepositValueInformationEvent transfer(Transfer transfer) {
        this.transfer = transfer;
        return this;
    }
}
