package org.example.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.example.model.Connect;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private final Connect connect = new Connect();
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast()
    }
}
