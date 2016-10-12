package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.salt.Ed25519;

public class AddressInformationEvent extends SignedMessage {
    private long address;
    private Bytes publicKey;
    // add verifiable facts such as verified address

    public AddressInformationEvent(long sourceAddress, long eventTime, long address, Bytes publicKey) {
        super(sourceAddress, eventTime);
        this.address = address;
        this.publicKey = publicKey;
    }


    public AddressInformationEvent() {
        super();
    }

    @Override
    protected void readMarshallable2(BytesIn bytes) {
        if (publicKey == null) publicKey = Bytes.allocateDirect(Ed25519.PUBLIC_KEY_LENGTH);
        publicKey.clear();
        bytes.read(publicKey, Ed25519.PUBLIC_KEY_LENGTH);
        address = bytes.readLong();
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {
        bytes.write(publicKey);
        bytes.writeLong(address);
    }

    @Override
    protected int messageType() {
        return MethodIds.ADDRESS_INFORMATION_EVENT;
    }

    public Bytes publicKey() {
        return publicKey;
    }

    public AddressInformationEvent publicKey(Bytes publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public long address() {
        return address;
    }

    public AddressInformationEvent address(long address) {
        this.address = address;
        return this;
    }
}
