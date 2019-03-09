package netty.fifthexample;


import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: TestSocket
 * @Description: TODO
 * @date 2019-02-18  21:39
 */

public class TestSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(9999));
        byte[] bytes = new byte[10];
        int len;
        while (true){

            System.out.println("qidaonidedaolai");
             Socket socket = serverSocket.accept();
            System.out.println("----------------");
             InputStream inputStream =  socket.getInputStream();
             StringBuffer sb = new StringBuffer();
             while((len = inputStream.read(bytes)) != -1 ){
                 sb.append(new String(bytes,0,len,"UTF-8"));
                 System.out.println(sb);
             }

             System.out.println(sb);
             inputStream.close();


        }



    }
}
