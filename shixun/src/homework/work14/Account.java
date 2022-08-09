package homework.work14;

import java.math.BigDecimal;

import java.util.concurrent.locks.ReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Account {

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    private BigDecimal balnace = new BigDecimal("100");

    //充值

    public void add(BigDecimal amount ) throws InterruptedException {

        //写锁

        lock.writeLock().lock();

        System.out.println(" 开始充值，线程名： " + Thread.currentThread().getName());

        try {

            Thread.sleep(2000);

            balnace = balnace.add(amount);

            System.out.println(" 结束充值，线程名： " + Thread.currentThread().getName());

        } catch (InterruptedException e) {

            e.printStackTrace();

        }finally {

            lock.writeLock().unlock();

        }

    }


    //查询余额

    public void getBalace() {

        //读锁

        lock.readLock().lock();

        try {

            System.out.println("开始查询线程名： " + Thread.currentThread().getName() );

            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println("查询结果线程名： " + Thread.currentThread().getName() +", 余额：" + balnace);

        }finally {

            lock.readLock().unlock();

        }

    }

}
