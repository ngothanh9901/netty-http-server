package org.example.handler;

import io.netty.handler.traffic.ChannelTrafficShapingHandler;
import org.example.dao.ConnectDao;
import org.example.model.Connect;

public class ServerTrafficHandler extends ChannelTrafficShapingHandler {
    private static final int CHECK_INTERVAL = 0;
    private ConnectDao connectDao;
    private Connect connect;
    private double durationMillis;
    private long receivedBytes;
    private long sendBytes;

    private ServerTrafficHandler(long checkInterval) {
        super(checkInterval);
    }
    public ServerTrafficHandler(long writeLimit, long readLimit, long checkInterval, long maxTime) {
        super(writeLimit, readLimit, checkInterval, maxTime);
    }
    public ServerTrafficHandler(Connect _connect) {
        this(CHECK_INTERVAL);

        this.connectDao = getDaoFactory(H2).getConnectionDao();
        this._connect = _connect;
    }

}
