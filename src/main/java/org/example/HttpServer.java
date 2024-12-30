package org.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.example.db.DBManager;
import org.example.util.ConfigReader;

import java.io.IOException;

public class HttpServer {
    private final static ConfigReader CONFIG_READER = new ConfigReader("./config");
    public void start() throws Exception {
        DBManager dbManager = new DBManager();
        dbManager.initialiseDB();

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap()
                .option(ChannelOption.SO_BACKLOG, 1024)
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler();

        int port = parsePort();

        Channel ch = b.bind(port).sync().channel();

        System.err.println("HTTP server started... \n" +
                "navigate to http://127.0.0.1:" + port + '/');

        ch.closeFuture().sync();
    }

    private int parsePort() throws IOException {
        return Integer.parseInt(CONFIG_READER.getConfigs().getProperty("server.port"));
    }
}
