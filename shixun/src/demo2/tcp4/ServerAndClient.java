package demo2.tcp4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAndClient {

    String readline = null;
    String inTemp = null;
    String turnLine = "\n";
    final String client = "Client:";
    final String server = "Server:";
    ServerSocket serverSocket;
    Socket socket;
    int port = 4000;
    byte ipAddressTemp[] = {127, 0, 0, 1};


    public void server() throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();
    }

    public void client() throws IOException {
        InetAddress ipAddress = InetAddress.getByAddress(ipAddressTemp);
        socket = new Socket(ipAddress, port);
    }

    public void tow() throws IOException {

        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

        while (readline != "bye") {
            inTemp = socketIn.readLine();
            System.out.println(client + turnLine + inTemp);
            System.out.println(server);
            readline = systemIn.readLine();
            socketOut.println(readline);
            socketOut.flush();
        }

        systemIn.close();
        socketIn.close();
        socketOut.close();
        socket.close();
        serverSocket.close();

    }
}
