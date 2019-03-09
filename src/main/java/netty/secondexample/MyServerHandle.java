package netty.secondexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MyServerHandle
 * @Description: TODO
 * @date 2019-02-12  21:12
 */

public class MyServerHandle extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println(channelHandlerContext.channel().remoteAddress() + ", " + s);
        channelHandlerContext.writeAndFlush("from server : " + UUID.randomUUID());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("来自服务端的问候");
    }
}
