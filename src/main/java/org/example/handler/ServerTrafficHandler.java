package org.example.handler;

import io.netty.handler.traffic.ChannelTrafficShapingHandler;

public class ServerTrafficHandler extends ChannelTrafficShapingHandler {
    private static final int CHECK_INTERVAL = 0;
    private Connect

    public ServerTrafficHandler(long writeLimit, long readLimit, long checkInterval, long maxTime) {
        super(writeLimit, readLimit, checkInterval, maxTime);
    }
}
