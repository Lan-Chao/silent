package netty.secondexample;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

import java.time.LocalDateTime;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MyClientHandler
 * @Description: TODO
 * @date 2019-02-12  21:03
 */

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {

        System.out.println(channelHandlerContext.channel().remoteAddress());
        System.out.println("收到服务端的消息：" + s);
        channelHandlerContext.writeAndFlush("from Client : " + LocalDateTime.now());

    }
}
