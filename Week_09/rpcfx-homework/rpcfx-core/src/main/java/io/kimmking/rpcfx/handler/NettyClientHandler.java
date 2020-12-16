package io.kimmking.rpcfx.handler;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;
import java.nio.charset.StandardCharsets;

/**
 * @Author: hyhy
 * @Date: 2020/12/15 7:59 下午
 */

public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private RpcfxRequest req;

    public NettyClientHandler(RpcfxRequest req){
        this.req = req;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        URI uri = new URI("/");
        String data = JSON.toJSONString(req);
        FullHttpRequest request = new DefaultFullHttpRequest(
                HttpVersion.HTTP_1_1, HttpMethod.POST, uri.toASCIIString(), Unpooled.wrappedBuffer(data.getBytes(StandardCharsets.UTF_8)));


        request.headers().set("Host", "127.0.0.1");
        request.headers().set("Connection", HttpHeaderValues.KEEP_ALIVE);
        request.headers().set("Content-Type", HttpHeaderValues.APPLICATION_JSON);

        request.headers().set("Content-Length", request.content().readableBytes());

        ctx.writeAndFlush(request);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg -> "+msg);
        if(msg instanceof FullHttpResponse){
            FullHttpResponse response = (FullHttpResponse)msg;
            ByteBuf buf = response.content();
            String result = buf.toString(CharsetUtil.UTF_8);
            System.out.println("response -> "+result);
        }

    }
}

