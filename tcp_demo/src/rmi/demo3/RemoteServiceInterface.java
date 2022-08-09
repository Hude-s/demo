package rmi.demo3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RemoteServiceInterface extends Remote {
    public List<UserInfo> queryAllUserInfo() throws RemoteException;
}
