package cash.xcl.api;

import cash.xcl.api.dto.*;
import net.cangqun343.chronicle.core.io.Closeable;

public interface WeeklyEvents extends Closeable {
    // weekly events
    void transactionBlockEvent(TransactionBlockEvent transactionBlockEvent);

    void treeBlockEvent(TreeBlockEvent treeBlockEvent);

    void feesEvent(FeesEvent feesEvent);

    void createNewAddressEvent(CreateNewAddressEvent createNewAddressEvent);

    void exchangeRateEvent(ExchangeRateEvent exchangeRateEvent);

    void openingBalanceEvent(OpeningBalanceEvent openingBalanceEvent);

    void currentBalanceEvent(CurrentBalanceEvent currentBalanceEvent);

    void serviceNodesEvent(ServiceNodesEvent serviceNodesEvent);

    // FIXME work in progress - move me to the correct interface

}
