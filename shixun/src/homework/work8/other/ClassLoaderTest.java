package homework.work8.other;



public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader loader = Object.class.getClassLoader();

        System.out.println(loader);
        loader.loadClass("Test2");
        //Class.forName("Test2");
        //Class.forName("Test2",false,loader);

    }

    public void test() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
