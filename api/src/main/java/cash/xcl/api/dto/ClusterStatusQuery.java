package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.bytes.BytesOut;

// FIXME needs reviewing/completing
// queries the status of the nodes in the current cluster
public class ClusterStatusQuery extends SignedMessage {
    public ClusterStatusQuery(long sourceAddress, long eventTime) {
        super(sourceAddress, eventTime);
    }

    public ClusterStatusQuery() {

    }

    @Override
    protected void readMarshallable2(BytesIn<?> bytes) {

    }

    @Override
    public int messageType() {
        return MessageTypes.CLUSTER_STATUS_QUERY;
    }

    @Override
    protected void writeMarshallable2(BytesOut<?> bytes) {

    }
}
