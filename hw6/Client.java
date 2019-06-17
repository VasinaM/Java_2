package hw6;

import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("Сообщение: ");
                            String word = null;
                            try {
                                word = reader.readLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                out.write(word + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

                //out.flush();
                while (true) {
                    String serverWord = in.readLine();
                    System.out.println(serverWord);
                }
            }catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    System.out.println("Client close");
                    clientSocket.close();
                    in.close();
                    out.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

