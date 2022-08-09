package homework.work12;

import org.junit.Test;

public class PicTest {
    @Test
    public void clientTest() {
        PicClient picClient = new PicClient();
        picClient.connect();
    }

    @Test
    public void serverTest() {
        PicServer picServer = new PicServer();
        picServer.connect();
    }
}
