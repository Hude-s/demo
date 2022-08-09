package rmi.demo1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 使用的是本地rmi注册表
 * 2、继承UnicastRemoteObject（单播远程对象），实现定义的接口
 *
 * 服务端实现类
 */
public class HelloServerImpl extends UnicastRemoteObject implements RemoteServiceInterface{

    private static final long serialVersionUID = -6020647384618378934L;

    protected HelloServerImpl() throws RemoteException {
        super();
    }

    /**
     * 业务层
     * @throws RemoteException
     */
    @Override
    public void sayHello() throws RemoteException {
        System.out.println("hello,here is the rmi-server");
    }
}
