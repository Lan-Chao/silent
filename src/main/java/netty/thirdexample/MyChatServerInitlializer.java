package netty.thirdexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.logging.SocketHandler;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: MyChatServerInitlializer
 * @Description: TODO
 * @date 2019-02-12  22:00
 */

public class MyChatServerInitlializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline  = socketChannel.pipeline();

        channelPipeline.addLast(new DelimiterBasedFrameDecoder(4096,Delimiters.lineDelimiter()));
        channelPipeline.addLast(new StringDecoder());
        channelPipeline.addLast(new StringEncoder());
        channelPipeline.addLast(new MyChatServerHandler());



    }
}
