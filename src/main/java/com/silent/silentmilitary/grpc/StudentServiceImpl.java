package com.silent.silentmilitary.grpc;

import com.silent.silentmilitary.proto.*;
import io.grpc.stub.StreamObserver;

/**
 * @author : silent【agzhchren@gmail.com】
 * @Title: StudentServiceImpl
 * @Description: TODO
 * @date 2019-03-08  0:35
 */

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase {
    @Override
    public void getRealNameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("收到客户端的请求，用户名：" + request.getUsername());
        responseObserver.onNext(MyResponse.newBuilder().setRealname("zcr").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        super.getStudentsByAge(request, responseObserver);
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {
        return super.getStudentsWrapperByAges(responseObserver);
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver) {
        return super.biTalk(responseObserver);
    }
}
