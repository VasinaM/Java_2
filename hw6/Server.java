package hw6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        try {
            try{
                server = new ServerSocket(4004);
                System.out.println("Сервер запущен");
                clientSocket = server.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            String word = null;
                            try {
                                word = in.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println(word);

                        }
                    }
                }).start();
                while (true) {
                    String msg = in.readLine();
                    if (msg.equals("/end")) {
                        break;
                    }
                    System.out.println("Client: " + msg);
                    out.flush();
                }
            }catch (IOException e) {
                e.printStackTrace();
                }
            } finally {
            try {
                clientSocket.close();
                server.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
