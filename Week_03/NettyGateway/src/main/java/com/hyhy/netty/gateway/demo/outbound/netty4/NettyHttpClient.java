package com.hyhy.netty.gateway.demo.outbound.netty4;//package io.github.kimmking.gateway.outbound;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.string.StringDecoder;


public class NettyHttpClient {
    private String host = "127.0.0.1";
    private int port = 8808;

    public NettyHttpClient(String backendUrl) {
        String bkUrl = backendUrl.endsWith("/") ? backendUrl.substring(0, backendUrl.length() - 1) : backendUrl;
//        port = Integer.valueOf(bkUrl.substring(bkUrl.lastIndexOf(":") + 1, bkUrl.length()));
//        host = bkUrl.substring(bkUrl.lastIndexOf("/") + 1, bkUrl.lastIndexOf(":"));
    }

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        try {
            connect(fullRequest,ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void connect(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) throws Exception {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
//                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
//                    ch.pipeline().addLast(new StringDecoder());
////                     //客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
//                    ch.pipeline().addLast(new HttpRequestEncoder());
                    ch.pipeline().addLast(new NettyHttpClientOutboundHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync();
            f.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
        }

    }
}