package cash.xcl.api;

import cash.xcl.api.dto.*;
import net.cangqun343.chronicle.core.io.Closeable;

public interface ServerIn extends Closeable {
    void depositValueCommand(DepositValueCommand depositValueCommand);

    void withdrawValueCommand(WithdrawValueCommand withdrawValueCommand);

    void transactionBlockEvent(TransactionBlockEvent transactionBlockEvent);

    void treeBlockEvent(TreeBlockEvent treeBlockEvent);

    void subscriptionCommand(SubscriptionCommand subscriptionCommand);
}
