package rmi.demo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteUnicastServiceImpl extends UnicastRemoteObject implements RemoteServiceInterface {

    private static final long serialVersionUID = 8501760694844812137L;

    protected RemoteUnicastServiceImpl() throws RemoteException {
//        super();
    }

    @Override
    public List<UserInfo> queryAllUserInfo() throws RemoteException {
        List<UserInfo> users = new ArrayList<>();
        UserInfo user1 = new UserInfo();
        user1.setAge(21);
        user1.setDesc("userDesc");
        user1.setUserName("userName");
        user1.setSex(true);
        users.add(user1);

        UserInfo user2 = new UserInfo();
        user2.setAge(21);
        user2.setDesc("userDesc2");
        user2.setUserName("userName2");
        user2.setSex(false);
        users.add(user2);
        return users;
    }
}
