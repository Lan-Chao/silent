package netty.thirdexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import netty.secondexample.MyClientInitializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MyChatClient
 * @Description: TODO
 * @date 2019-02-12  22:50
 */

public class MyChatClient {
    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup eventExecutors = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventExecutors).channel(NioSocketChannel.class).handler(new MyChatClientInitializer());

            Channel channel = bootstrap.connect("localhost",8888).sync().channel();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            for (;;){
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
