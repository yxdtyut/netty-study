package com.yxdtyut.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: Student.proto")
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.yxdtyut.grpc.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.yxdtyut.grpc.MyRequest,
      com.yxdtyut.grpc.MyResponse> getGetRealnameBuUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getRealnameBuUsername",
      requestType = com.yxdtyut.grpc.MyRequest.class,
      responseType = com.yxdtyut.grpc.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.yxdtyut.grpc.MyRequest,
      com.yxdtyut.grpc.MyResponse> getGetRealnameBuUsernameMethod() {
    io.grpc.MethodDescriptor<com.yxdtyut.grpc.MyRequest, com.yxdtyut.grpc.MyResponse> getGetRealnameBuUsernameMethod;
    if ((getGetRealnameBuUsernameMethod = StudentServiceGrpc.getGetRealnameBuUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealnameBuUsernameMethod = StudentServiceGrpc.getGetRealnameBuUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealnameBuUsernameMethod = getGetRealnameBuUsernameMethod =
              io.grpc.MethodDescriptor.<com.yxdtyut.grpc.MyRequest, com.yxdtyut.grpc.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getRealnameBuUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("getRealnameBuUsername"))
              .build();
        }
      }
    }
    return getGetRealnameBuUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest,
      com.yxdtyut.grpc.StudentResponse> getGetStudentByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentByAge",
      requestType = com.yxdtyut.grpc.StudentRequest.class,
      responseType = com.yxdtyut.grpc.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest,
      com.yxdtyut.grpc.StudentResponse> getGetStudentByAgeMethod() {
    io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest, com.yxdtyut.grpc.StudentResponse> getGetStudentByAgeMethod;
    if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentByAgeMethod = getGetStudentByAgeMethod =
              io.grpc.MethodDescriptor.<com.yxdtyut.grpc.StudentRequest, com.yxdtyut.grpc.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StudentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentByAge"))
              .build();
        }
      }
    }
    return getGetStudentByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest,
      com.yxdtyut.grpc.StudentResponseList> getGetStudentListByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentListByAges",
      requestType = com.yxdtyut.grpc.StudentRequest.class,
      responseType = com.yxdtyut.grpc.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest,
      com.yxdtyut.grpc.StudentResponseList> getGetStudentListByAgesMethod() {
    io.grpc.MethodDescriptor<com.yxdtyut.grpc.StudentRequest, com.yxdtyut.grpc.StudentResponseList> getGetStudentListByAgesMethod;
    if ((getGetStudentListByAgesMethod = StudentServiceGrpc.getGetStudentListByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentListByAgesMethod = StudentServiceGrpc.getGetStudentListByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentListByAgesMethod = getGetStudentListByAgesMethod =
              io.grpc.MethodDescriptor.<com.yxdtyut.grpc.StudentRequest, com.yxdtyut.grpc.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentListByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StudentResponseList.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("GetStudentListByAges"))
              .build();
        }
      }
    }
    return getGetStudentListByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.yxdtyut.grpc.StreamRequest,
      com.yxdtyut.grpc.StreamResponse> getBiTalkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTalk",
      requestType = com.yxdtyut.grpc.StreamRequest.class,
      responseType = com.yxdtyut.grpc.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.yxdtyut.grpc.StreamRequest,
      com.yxdtyut.grpc.StreamResponse> getBiTalkMethod() {
    io.grpc.MethodDescriptor<com.yxdtyut.grpc.StreamRequest, com.yxdtyut.grpc.StreamResponse> getBiTalkMethod;
    if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBiTalkMethod = StudentServiceGrpc.getBiTalkMethod) == null) {
          StudentServiceGrpc.getBiTalkMethod = getBiTalkMethod =
              io.grpc.MethodDescriptor.<com.yxdtyut.grpc.StreamRequest, com.yxdtyut.grpc.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BiTalk"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.yxdtyut.grpc.StreamResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StudentServiceMethodDescriptorSupplier("BiTalk"))
              .build();
        }
      }
    }
    return getBiTalkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @java.lang.Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @java.lang.Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @java.lang.Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealnameBuUsername(com.yxdtyut.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.MyResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetRealnameBuUsernameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.yxdtyut.grpc.StudentRequest request,
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentRequest> getStudentListByAges(
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponseList> responseObserver) {
      return asyncUnimplementedStreamingCall(getGetStudentListByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StreamResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiTalkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealnameBuUsernameMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.yxdtyut.grpc.MyRequest,
                com.yxdtyut.grpc.MyResponse>(
                  this, METHODID_GET_REALNAME_BU_USERNAME)))
          .addMethod(
            getGetStudentByAgeMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.yxdtyut.grpc.StudentRequest,
                com.yxdtyut.grpc.StudentResponse>(
                  this, METHODID_GET_STUDENT_BY_AGE)))
          .addMethod(
            getGetStudentListByAgesMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.yxdtyut.grpc.StudentRequest,
                com.yxdtyut.grpc.StudentResponseList>(
                  this, METHODID_GET_STUDENT_LIST_BY_AGES)))
          .addMethod(
            getBiTalkMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.yxdtyut.grpc.StreamRequest,
                com.yxdtyut.grpc.StreamResponse>(
                  this, METHODID_BI_TALK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealnameBuUsername(com.yxdtyut.grpc.MyRequest request,
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.MyResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetRealnameBuUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.yxdtyut.grpc.StudentRequest request,
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetStudentByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentRequest> getStudentListByAges(
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponseList> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getGetStudentListByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StreamRequest> biTalk(
        io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StreamResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiTalkMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.yxdtyut.grpc.MyResponse getRealnameBuUsername(com.yxdtyut.grpc.MyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetRealnameBuUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.yxdtyut.grpc.StudentResponse> getStudentByAge(
        com.yxdtyut.grpc.StudentRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetStudentByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.yxdtyut.grpc.MyResponse> getRealnameBuUsername(
        com.yxdtyut.grpc.MyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetRealnameBuUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REALNAME_BU_USERNAME = 0;
  private static final int METHODID_GET_STUDENT_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_LIST_BY_AGES = 2;
  private static final int METHODID_BI_TALK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REALNAME_BU_USERNAME:
          serviceImpl.getRealnameBuUsername((com.yxdtyut.grpc.MyRequest) request,
              (io.grpc.stub.StreamObserver<com.yxdtyut.grpc.MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_BY_AGE:
          serviceImpl.getStudentByAge((com.yxdtyut.grpc.StudentRequest) request,
              (io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_LIST_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentListByAges(
              (io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StudentResponseList>) responseObserver);
        case METHODID_BI_TALK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTalk(
              (io.grpc.stub.StreamObserver<com.yxdtyut.grpc.StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StudentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.yxdtyut.grpc.StudentProto3.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StudentService");
    }
  }

  private static final class StudentServiceFileDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier {
    StudentServiceFileDescriptorSupplier() {}
  }

  private static final class StudentServiceMethodDescriptorSupplier
      extends StudentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StudentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StudentServiceFileDescriptorSupplier())
              .addMethod(getGetRealnameBuUsernameMethod())
              .addMethod(getGetStudentByAgeMethod())
              .addMethod(getGetStudentListByAgesMethod())
              .addMethod(getBiTalkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
