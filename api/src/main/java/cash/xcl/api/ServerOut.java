package cash.xcl.api;

import cash.xcl.api.dto.NewAddressRejectedEvent;
import net.cangqun343.chronicle.core.io.Closeable;

public interface ServerOut extends Closeable {
    void newAddressRejectedEvent(NewAddressRejectedEvent newAddressRejectedEvent);
}
