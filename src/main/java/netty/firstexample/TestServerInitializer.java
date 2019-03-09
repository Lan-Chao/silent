package netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: TestServerInitializer
 * @Description: TODO
 * @date 2019-02-01  18:22
 */

public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline  = socketChannel.pipeline();
        pipeline.addLast("HttpServerCodec",new HttpServerCodec());  //请求和相应的编解码
        pipeline.addLast("testHttpServerHandle",new TestHttpServerHandle());
    }
}













