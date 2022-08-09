package demo2.tcp4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends ServerAndClient {

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.client();
        client.tow();
    }

}
