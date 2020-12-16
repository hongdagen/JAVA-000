package io.kimmking.rpcfx.handler;


import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * @Author: hyhy
 * @Date: 2020/12/15 8:53
 */
public class NettyReqClient {

    public RpcfxResponse post(RpcfxRequest req, String url) {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(new NioEventLoopGroup());
            bootstrap.channel(NioSocketChannel.class);

            bootstrap.handler(new ChannelInitializer<SocketChannel>() {

                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new LoggingHandler(LogLevel.INFO));
                    pipeline.addLast(new NettyClientHandler(req));
                }
            });
            ChannelFuture f = bootstrap.connect("127.0.0.1", 8080).sync();
            f.channel().closeFuture().sync();

        } catch ( InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
