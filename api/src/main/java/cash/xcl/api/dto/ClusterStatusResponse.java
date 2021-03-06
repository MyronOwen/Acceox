package cash.xcl.api.dto;

import net.cangqun343.chronicle.bytes.BytesIn;
import net.cangqun343.chronicle.bytes.BytesOut;

// FIXME needs reviewing/completing
// returns the status of the nodes in the current cluster
public class ClusterStatusResponse extends SignedMessage {

    private ClusterStatusQuery clusterStatusQuery;

    // cluster contains the nodes
    // and each node contains its own status
    private Cluster cluster;

    public ClusterStatusResponse(ClusterStatusQuery clusterStatusQuery, Cluster cluster) {
        this.clusterStatusQuery = clusterStatusQuery;
        this.cluster = cluster;
    }

    public ClusterStatusResponse(long sourceAddress, long eventTime, ClusterStatusQuery clusterStatusQuery, Cluster cluster) {
        super(sourceAddress, eventTime);
        this.clusterStatusQuery = clusterStatusQuery;
        this.cluster = cluster;
    }

    public ClusterStatusResponse() {
        super();
    }

    @Override
    protected void readMarshallable2(BytesIn<?> bytes) {
    }

    @Override
    protected void writeMarshallable2(BytesOut<?> bytes) {
    }

    @Override
    public int messageType() {
        return MessageTypes.CLUSTER_STATUS_RESPONSE;
    }
}
