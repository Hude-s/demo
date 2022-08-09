package demo6;

@SuppressWarnings("all")
public class Calculate {
    //    public Calculate(){}
    @Check
    @Check1
    public double add(double a, double b) {
        System.out.println(a + b);
        System.out.println("---------");
        return a + b;
    }

    @Check
    @Check1
    public double sub(double a, double b) {
        return a - b;
    }

    @Check
    @Check1
    public void div(int a, int b) {
        System.out.println(a / b);
    }

    @Check
    @Check1
    public double mul(double a, double b) {
        return a * b;
    }


}
