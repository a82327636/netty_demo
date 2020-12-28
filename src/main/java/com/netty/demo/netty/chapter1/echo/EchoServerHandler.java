package com.netty.demo.netty.chapter1.echo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ProjectName: netty_demo
 * @Package: com.netty.demo.netty.chapter1.echo
 * @ClassName: EchoServerHandler
 * @Author: zwj
 * @Description: 注释
 * @Date: 2020/12/28 10:20
 * @Version: 1.0
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
