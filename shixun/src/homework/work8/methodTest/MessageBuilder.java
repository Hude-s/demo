package homework.work8.methodTest;

/**
 * 函数式编程
 * 1、声明一个有且仅有一个抽象方法的接口
 * 2、使用时，使用匿名内部类进行调用方法？
 * 函数式编程的好处：
 * 能够延迟加载，在编码时能实现在需要时加载，避免内存浪费
 */
@FunctionalInterface
public interface MessageBuilder {
    public abstract String messageBuilder();
}
