package rmi.demo2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteUnicastTest {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        RemoteUnicastServiceImpl remoteUnicastService = new RemoteUnicastServiceImpl();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://localhost/queryAllUserInfo",remoteUnicastService);
        System.out.println("服务已开启");
    }
}
