package rmi.demo1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义服务端接口
 */
public interface RemoteServiceInterface extends Remote {
    /**
     *
     */
    public void sayHello() throws RemoteException;

}
