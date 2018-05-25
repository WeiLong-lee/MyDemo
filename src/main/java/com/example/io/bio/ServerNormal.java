package com.example.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by LiWeilong on 2018/5/25.
 */
public class ServerNormal {
    // 默认端口号
    private static int DEFAULT_PORT = 12345;
    // 单例的ServerSocket
    private static ServerSocket server;
    //根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
    public static void start() throws IOException{
        start(DEFAULT_PORT);
    }
    public synchronized static void start(int port) throws IOException {

        if(server !=null) return ;
        try{
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号 port:"+port);
            Socket socket;
            while (true){
                socket = server.accept();
                new Thread(new ServerHandler(socket)).start();
            }


        }finally {
            if(server !=null){
                System.out.println("服务器关闭。。。");
                server.close();
                server = null;

            }
        }


    }


}
