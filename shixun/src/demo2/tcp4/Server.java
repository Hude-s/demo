package demo2.tcp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends ServerAndClient {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.server();
        server.tow();
    }
}