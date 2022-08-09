package homework.work14;

public class GetBalanceThread extends Thread{

    private Account account;

    public GetBalanceThread(Account account) {

        super();

        this.account = account;

    }


    @Override

    public void run() {

        account.getBalace();

    }


    public Account getAccount() {

        return account;

    }

    public void setAccount(Account account) {

        this.account = account;

    }

}