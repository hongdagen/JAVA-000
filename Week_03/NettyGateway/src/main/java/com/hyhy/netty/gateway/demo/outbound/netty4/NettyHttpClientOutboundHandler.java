package com.hyhy.netty.gateway.demo.outbound.netty4;


import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class NettyHttpClientOutboundHandler extends ChannelInboundHandlerAdapter {
//    private ChannelHandlerContext serverCtx;
//
//    public NettyHttpClientOutboundHandler(final ChannelHandlerContext serverCtx) {
//        this.serverCtx = serverCtx;
//    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client recv msg::"+msg.toString());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("aaa",CharsetUtil.UTF_8));
    }
}