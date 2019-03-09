package netty.secondexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MyClient
 * @Description: TODO
 * @date 2019-02-12  20:47
 */

public class MyClient {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new MyClientInitializer());

            ChannelFuture channelFuture = bootstrap.connect("localhost",8888).sync();
            channelFuture.channel().closeFuture().sync();


        }finally {
            eventExecutors.shutdownGracefully();
        }


    }

}
