package rmi.demo2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class RemoteClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        RemoteServiceInterface remoteServiceInterface = (RemoteServiceInterface) Naming.lookup("rmi://localhost/queryAllUserInfo");
        List<UserInfo> users = remoteServiceInterface.queryAllUserInfo();
        System.out.println(users);

    }
}
