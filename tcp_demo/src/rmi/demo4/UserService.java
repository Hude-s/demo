package rmi.demo4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {
    User findUser(String userId) throws RemoteException;
}
