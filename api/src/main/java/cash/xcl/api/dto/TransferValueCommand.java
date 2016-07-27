package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;

public class TransferValueCommand extends SignedMessage {
    long toAddress;
    double amount;
    String currency;

    @Override
    protected void readMarshallable2(BytesIn bytes) {
        toAddress = bytes.readLong();
        amount = bytes.readDouble();
        currency = bytes.readUtf8();
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {
        bytes.writeLong(toAddress);
        bytes.writeDouble(amount);
        bytes.writeUtf8(currency);
    }

    @Override
    protected int messageType() {
        return MethodIds.TRANSFER_VALUE_COMMAND;
    }

    public long toAddress() {
        return toAddress;
    }

    public TransferValueCommand toAddress(long toAddress) {
        this.toAddress = toAddress;
        return this;
    }

    public double amount() {
        return amount;
    }

    public TransferValueCommand amount(double amount) {
        this.amount = amount;
        return this;
    }

    public String currency() {
        return currency;
    }

    public TransferValueCommand currency(String currency) {
        this.currency = currency;
        return this;
    }
}
