package other;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: Client
 * @Description: TODO
 * @date 2019-03-22  0:11
 */

public class Client {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 9999);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        // 先向服务端发送数据
        os.write("Hello, Server!".getBytes());
        // 读取服务端发来的数据
        int b;
        while ((b = is.read()) != 0) {
            System.out.print((char) b);
        }
        System.out.println();
        socket.close();

    }
}
