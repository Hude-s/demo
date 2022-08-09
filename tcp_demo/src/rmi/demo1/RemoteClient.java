package rmi.demo1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//客户端调用
public class RemoteClient {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RemoteServiceInterface remoteServiceInterface = (RemoteServiceInterface) Naming.lookup("rmi://127.0.0.1/sayHello");
        remoteServiceInterface.sayHello();
    }

}
