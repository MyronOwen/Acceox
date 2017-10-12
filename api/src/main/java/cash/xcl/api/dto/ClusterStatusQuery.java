package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.Bytes;
import net.cangqun343.chronicle.bytes.BytesIn;

// FIXME needs reviewing/completing
// queries the status of the nodes in the current cluster
public class ClusterStatusQuery extends SignedMessage {
    public ClusterStatusQuery(long sourceAddress, long eventTime) {
        super(sourceAddress, eventTime);
    }

    public ClusterStatusQuery() {

    }

    @Override
    protected void readMarshallable2(BytesIn bytes) {

    }

    @Override
    public int messageType() {
        return MethodIds.CLUSTER_STATUS_QUERY;
    }

    @Override
    protected void writeMarshallable2(Bytes bytes) {

    }
}
