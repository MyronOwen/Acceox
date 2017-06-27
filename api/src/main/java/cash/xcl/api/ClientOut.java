package cash.xcl.api;

import cash.xcl.api.dto.*;
import net.cangqun343.chronicle.core.io.Closeable;

/**
 * Includes all Queries and Commands expected to come from a client.
 */
public interface ClientOut extends Closeable {
    void createNewAddressCommand(CreateNewAddressCommand createNewAddressCommand);

    void transferValueCommand(TransferValueCommand transferValueCommand);

    void clusterTransferStep1Command(ClusterTransferStep1Command clusterTransferStep1Command);

    void subscriptionQuery(SubscriptionQuery subscriptionQuery);

    void newLimitOrderCommand(NewLimitOrderCommand newLimitOrderCommand);
    void newMarketOrderCommand(NewMarketOrderCommand newMarketOrderCommand);
    void cancelOrderCommand(CancelOrderCommand cancelOrderCommand);

}
