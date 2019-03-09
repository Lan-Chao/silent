package netty.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: TestNIO
 * @Description: TODO
 * @date 2019-02-16  8:52
 */

public class TestNIO {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("hello");
        FileChannel fileChannel = inputStream.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);

        fileChannel.read(buffer);

        System.out.println( buffer.limit() );
        buffer.flip();
        System.out.println( buffer.limit() );


        while (buffer.hasRemaining()){
            byte b = buffer.get();
            System.out.println((char) b);
        }

    }
}
