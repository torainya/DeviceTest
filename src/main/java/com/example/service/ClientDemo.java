//package com.example.service;
//
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//
//
///**
// * 客户端
// *
// * @author tang
// */
//public class ClientDemo {
//
//    public static void main(String[] args) {
//        System.out.println("客户端启动....");
//        TTransport transport = null;
//        try {
//            // 设置调用的服务地址为本地，端口为8080,超时设置为30秒
//            transport = new TSocket("localhost", 8090, 30000);
//            // 协议要和服务端一致
//            TProtocol protocol = new TBinaryProtocol(transport);
//            Service.Client client = new Service.Client(protocol);
//            transport.open();
//            // 调用接口方法
//            String result = client.listen("1","1");
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != transport) {
//                transport.close();
//            }
//        }
//    }
//
//}