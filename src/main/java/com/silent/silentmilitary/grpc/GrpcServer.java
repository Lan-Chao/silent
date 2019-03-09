package com.silent.silentmilitary.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: GrpcServer
 * @Description: TODO
 * @date 2019-03-08  1:00
 */

public class GrpcServer {
    private Server server;
    public static void main(String[] args) throws IOException, InterruptedException {
        GrpcServer server1 = new GrpcServer();
        server1.server = ServerBuilder.forPort(9999).addService(new StudentServiceImpl()).build().start();
        System.out.println("服务启动");
        server1.server.awaitTermination();
    }
}
