package com.example.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by LiWeilong on 2018/5/25.
 * 客户端处理线程
 */
public class ServerHandler implements Runnable {
    private Socket socket;
    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader in =null;
        PrintWriter out =null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            String expression;
            String result;
            while (true) {
                // 通过 BufferReader 读取一行，如果读到输入流尾部，返回null，退出循环
                if ((expression = in.readLine()) == null) break;
                System.out.println("服务器收到消息：" + expression);
                try {
                    result = Calculator.cal(expression).toString();
                } catch (Exception e) {
                    result = "计算错误：" + e.getMessage();
                }
            }

        }catch (Exception e){

        }finally {
                //一些必要的清理工作
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    in = null;
                }
                if(out != null){
                    out.close();
                    out = null;
                }
                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    socket = null;
                }
            }
    }
}
