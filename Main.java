public class Main implements A{

    public static void test2() {
        System.out.println("Surya Kumar");
    }

    @Override
    public void test() {
        System.out.println("Surya Kumar");
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.test();   // ya
        test2();
    }

}
