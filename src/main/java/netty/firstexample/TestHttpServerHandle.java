package netty.firstexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: TestHttpServerHandle
 * @Description: TODO
 * @date 2019-02-01  18:30
 */

public class TestHttpServerHandle extends SimpleChannelInboundHandler<HttpObject> {


    private  int i;
    //读取客户端请求并相应
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, HttpObject httpObject) throws Exception {

        if(httpObject instanceof HttpRequest){
            System.out.println("开始处理 channelRead0 方法,i : " + i++);
            ByteBuf  context = Unpooled.copiedBuffer("hello world!",CharsetUtil.UTF_8);
            //FullHttpResponse 简化的响应对象
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,context);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,context.readableBytes());

            //真正的返给客户端，之前放在缓存里
            channelHandlerContext.writeAndFlush(response);
        }


    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }
}
