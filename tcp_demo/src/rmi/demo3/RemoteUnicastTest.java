package rmi.demo3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteUnicastTest {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
//        LocateRegistry.createRegistry(1099);
//        Naming.rebind("rmi://127.0.0.1/queryAllUserInfo",remoteUnicastService);

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

        RemoteUnicastServiceImpl remoteService = new RemoteUnicastServiceImpl();

        registry.rebind("queryAllUserInfo", remoteService);
    }
}
