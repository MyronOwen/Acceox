package cash.xcl.api;

import cash.xcl.api.dto.*;
import cash.xcl.net.TCPClientListener;
import cash.xcl.net.TCPConnection;
import cash.xcl.net.VanillaTCPClient;
import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.core.io.Closeable;
import net.cangqun343.chronicle.core.io.IORuntimeException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class XCLClient implements AllMessages, Closeable {
    final ThreadLocal<Bytes> bytesTL = ThreadLocal.withInitial(Bytes::allocateElasticDirect);
    private final VanillaTCPClient tcpClient;
    private final long address;
    private final Bytes secretKey;
    private final AllMessages allMessageListener;

    public XCLClient(String name,
                     List<InetSocketAddress> socketAddresses,
                     long address,
                     Bytes secretKey,
                     AllMessages allMessageListener) {
        this.address = address;
        this.secretKey = secretKey;
        this.allMessageListener = allMessageListener;
        this.tcpClient = new VanillaTCPClient(name, socketAddresses, new ClientListener());
    }

    @Override
    public void applicationMessageEvent(ApplicationMessageEvent applicationMessageEvent) {
        write(applicationMessageEvent);
    }

    @Override
    public void createNewAddressCommand(CreateNewAddressCommand createNewAddressCommand) {
        write(createNewAddressCommand);
    }

    @Override
    public void clusterTransferValueCommand(ClusterTransferValueCommand clusterTransferValueCommand) {
        write(clusterTransferValueCommand);
    }

    @Override
    public void feesEvent(FeesEvent feesEvent) {
        write(feesEvent);
    }

    @Override
    public void transferValueCommand(TransferValueCommand transferValueCommand) {
        write(transferValueCommand);
    }

    @Override
    public void transactionBlockEvent(TransactionBlockEvent transactionBlockEvent) {
        write(transactionBlockEvent);
    }

    @Override
    public void treeBlockEvent(TreeBlockEvent treeBlockEvent) {
        write(treeBlockEvent);
    }

    @Override
    public void newAddressRejectedEvent(NewAddressRejectedEvent newAddressRejectedEvent) {
        write(newAddressRejectedEvent);
    }

    @Override
    public void transferValueInformationEvent(TransferInformationEvent transferInformationEvent) {
        write(transferInformationEvent);
    }

    @Override
    public void transferValueRejectedEvent(TransferValueRejectedEvent transferValueRejectedEvent) {
        write(transferValueRejectedEvent);
    }

    @Override
    public void clusterTransferInformationEvent(ClusterTransferInformationEvent clusterTransferInformationEvent) {
        write(clusterTransferInformationEvent);
    }


    @Override
    public void clusterTransferValueRejectedEvent(ClusterTransferValueRejectedEvent clusterTransferValueRejectedEvent) {
        write(clusterTransferValueRejectedEvent);
    }

    @Override
    public void depositValueInformationEvent(DepositValueInformationEvent depositValueInformationEvent) {
        write(depositValueInformationEvent);
    }

    @Override
    public void depositValueRejectedEvent(DepositValueRejectedEvent depositValueRejectedEvent) {
        write(depositValueRejectedEvent);
    }

    @Override
    public void withdrawValueInformationEvent(WithdrawValueInformationEvent withdrawValueInformationEvent) {
        write(withdrawValueInformationEvent);
    }

    @Override
    public void withdrawValueRejectedEvent(WithdrawValueRejectedEvent withdrawValueRejectedEvent) {
        write(withdrawValueRejectedEvent);
    }

    @Override
    public void subscriptionSuccess(SubscriptionSuccess subscriptionSuccess) {
        write(subscriptionSuccess);
    }

    @Override
    public void subscriptionFailed(SubscriptionFailed subscriptionFailed) {
        write(subscriptionFailed);
    }

    @Override
    public void addressInformationEvent(AddressInformationEvent addressInformationEvent) {
        write(addressInformationEvent);
    }

    @Override
    public void exchangeRateEvent(ExchangeRateEvent exchangeRateEvent) {
        write(exchangeRateEvent);
    }

    @Override
    public void openingBalanceEvent(OpeningBalanceEvent openingBalanceEvent) {
        write(openingBalanceEvent);
    }

    @Override
    public void depositValueCommand(DepositValueCommand depositValueCommand) {
        write(depositValueCommand);
    }

    @Override
    public void withdrawValueCommand(WithdrawValueCommand withdrawValueCommand) {
        write(withdrawValueCommand);
    }






    @Override
    public void subscriptionCommand(SubscriptionCommand subscriptionCommand) {
        write(subscriptionCommand);
    }

    private void write(SignedMessage message) {
        try {
            if (!message.hasSignature()) {
                Bytes bytes = bytesTL.get();
                bytes.clear();
                message.sign(bytes, address, secretKey);
            }
            tcpClient.write(message.sigAndMsg());

        } catch (IOException e) {
            throw new IORuntimeException(e);
        }
    }

    class ClientListener implements TCPClientListener {
        final DtoParser parser = new DtoParser();

        @Override
        public void onMessage(TCPConnection client, Bytes bytes) throws IOException {
            try {
                parser.parseOne(bytes, allMessageListener);

            } catch (IORuntimeException iore) {
                if (iore.getCause() instanceof IOException)
                    throw (IOException) iore.getCause();
                throw iore;
            }
        }
    }

    @Override
    public void close() {
        tcpClient.close();
    }
}
