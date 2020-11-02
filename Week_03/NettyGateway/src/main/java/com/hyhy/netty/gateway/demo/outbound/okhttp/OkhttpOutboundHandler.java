package com.hyhy.netty.gateway.demo.outbound.okhttp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import okhttp3.*;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 10.29 作业1
 */
public class OkhttpOutboundHandler {

    private OkHttpClient client;
    private String backendUrl;

    // 构造
    public OkhttpOutboundHandler(String backendUrl) {
        this.backendUrl = backendUrl.endsWith("/") ? backendUrl.substring(0, backendUrl.length() - 1) : backendUrl;
        client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    // inbound调用
    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        Response response = sendReq(fullRequest);
        if (response != null && response.isSuccessful()) {
            sendBackInBoundServer(response, fullRequest, ctx);

        } else {

        }
    }

    // req2 proxy
    private Response sendReq(final FullHttpRequest fullRequest) {

        Set<String> headerNames = fullRequest.headers().names();


        Request.Builder bbuilde = new Request.Builder()
                .url(backendUrl)
                .header("Connection", "Keep-Alive");

        for (String key : headerNames) {
            bbuilde.header(key, fullRequest.headers().get(key));
        }
        Request req = bbuilde.build();

        if (client != null) {
            try {
                return client.newCall(req).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    // resp2inbound
    private void sendBackInBoundServer(Response resp, final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        // client拿到response后 重新封装一个"response"响应给inbound
        FullHttpResponse proxyMessage = null;

        try {
            byte[] body = resp.body().bytes();
            proxyMessage = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(body));
            proxyMessage.headers().set("Content-Type", resp.header("Content-Type"));
            proxyMessage.headers().set("Content-Length", resp.header("Content-Length"));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(proxyMessage).addListener(ChannelFutureListener.CLOSE);
                } else {
                    //response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(proxyMessage);
                }
            }
            ctx.flush();
        }

    }

}
