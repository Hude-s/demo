package demo2.tcp;

import org.junit.Test;

import java.io.IOException;

public class PicTest {
    @Test
    public void client() throws IOException {
        PicClient picClient = new PicClient();
        picClient.operation();

    }

    @Test
    public void server() throws IOException {
        PicServer picServer = new PicServer();
        picServer.operation();
    }
}
