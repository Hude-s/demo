package homework.work14;


import java.math.BigDecimal;

public class CzThread extends Thread{

    private Account account;

    public CzThread(Account account) {

        this.account = account;

    }


    @Override

    public void run() {

        try {

            account.add(new BigDecimal("100"));

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    public Account getAccount() {

        return account;

    }

    public void setAccount(Account account) {

        this.account = account;

    }

}