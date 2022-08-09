package rmi.demo4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    private static final long serialVersionUID = -1536092006304791178L;

    protected UserServiceImpl() throws RemoteException {
    }

    /**
     * 具体业务
     */
    @Override
    public User findUser(String userId) throws RemoteException {
        if("001".equals(userId)){
            User user = new User();

        }
        return null;
    }
}
