//package com.example.service;
//
//
//import com.example.service.ServiceImpl;
//import org.apache.thrift.TProcessor;
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.server.TServer;
//import org.apache.thrift.server.TSimpleServer;
//import org.apache.thrift.transport.TServerSocket;
//
//public class ServiceDemo {
//    public  static  final int  SERVER_PORT = 8090;
//    public void startServer() {
//        try {
//            System.out.println("TSimpleServer start ....");
//
//            //在这里调用了 Impl 规定了接受的方法和返回的参数
//            TProcessor tprocessor = new Service.Processor<Service.Iface>( new ServiceImpl());
//
//            TServerSocket serverTransport = new TServerSocket(SERVER_PORT);
//            TServer.Args tArgs = new TServer.Args(serverTransport);
//            tArgs.processor(tprocessor);
//            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//
//            TServer server = new TSimpleServer(tArgs);
//            server.serve();
//
//        } catch (Exception e) {
//            System.out.println("Server start error!!!");
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        ServiceDemo server = new ServiceDemo();
//        server.startServer();
//    }
//
//}