package com.silent.silentmilitary.grpc;

import com.silent.silentmilitary.proto.MyRequest;
import com.silent.silentmilitary.proto.MyResponse;
import com.silent.silentmilitary.proto.StudentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: GrpcClient
 * @Description: TODO
 * @date 2019-03-08  0:52
 */

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel =ManagedChannelBuilder.forAddress("localhost",9999).
                usePlaintext().build();
        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
        MyResponse myResponse = blockingStub.getRealNameByUsername(MyRequest.newBuilder().setUsername("hello").build());
        System.out.println(myResponse.getRealname());

    }
}
