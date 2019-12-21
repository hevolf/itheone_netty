package cn.enjoyedu.nio.nio;

import java.util.Scanner;

import static cn.enjoyedu.nio.Const.DEFAULT_PORT;
import static cn.enjoyedu.nio.Const.DEFAULT_SERVER_IP;

/**
 * @author Mark老师   享学课堂 https://enjoy.ke.qq.com
 * 类说明：nio通信客户端
 */
public class NioClient {
    private static NioClientHandle nioClientHandle;

    public static void start(){
        if(nioClientHandle !=null) {
            nioClientHandle.stop();
        }
        // 每个线程一个 nioClientHandle
        nioClientHandle = new NioClientHandle(DEFAULT_SERVER_IP,DEFAULT_PORT);
        new Thread(nioClientHandle,"Server").start();
    }
    //向服务器发送消息
    public static boolean sendMsg(String msg) throws Exception{
        nioClientHandle.sendMsg(msg);
        return true;
    }
    public static void main(String[] args) throws Exception {
        start();
        Scanner scanner = new Scanner(System.in);
        while(NioClient.sendMsg(scanner.next())) {
            ;
        }

    }

}
