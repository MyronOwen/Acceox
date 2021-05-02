package cash.xcl.api;

import cash.xcl.util.XCLBase32LongConverter;
import net.cangqun343.chronicle.wire.LongConversion;

@FunctionalInterface
public interface AllMessagesLookup {
    AllMessages to(
            @LongConversion(XCLBase32LongConverter.class)
                    long addressOrRegion);
}
