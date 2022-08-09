package homework.work8.methodTest;

public class MessageBuilderTest {
    public static void show(int level, MessageBuilder mb) {
        if (level == 1) {
            System.out.println(mb.messageBuilder());
        }
    }

    public static void main(String[] args) {
        String msg1 = " java ";
        String msg2 = " hello ";
        String msg3 = " world ";
        //使用lambda表达式简化
        show(2, () -> {
            return msg1 + msg2 + msg3;
        });

        //创建匿名内部类
        show(1, new MessageBuilder() {
            @Override
            public String messageBuilder() {
                return msg1 + msg2 + msg3;
            }
        });
    }
}
