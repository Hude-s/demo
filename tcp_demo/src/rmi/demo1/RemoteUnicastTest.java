package rmi.demo1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 * 注册服务端服务端接口
 */
public class RemoteUnicastTest {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);

        HelloServerImpl helloServer = new HelloServerImpl();
        Naming.rebind("rmi://127.0.0.1:1099/sayHello",helloServer);

    }
}
/**
 * rmi的使用
 *
 * 服务端：
 * 1、定义rmi服务接口,接口继承Remote
 * 2、编写接口的实现类，实现定义的接口，并且继承单播远程对象类，
 * 3、把rmi server服务注册到本地rmi注册表中
 * 客户端：
 * 3、
 */
