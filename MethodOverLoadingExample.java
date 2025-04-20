class Test {
    void display() {
        System.out.println("no parameter");
        
    }

    void display(int a) {
        System.out.println("One Parameter pass");
    }

    void display(int a, int b) {
        System.out.println("Two Para meters pass");
    }
}

class MethodOverLoadingExample {
    public static void main(String args[]) {
        Test test = new Test();
        test.display();
        test.display(10);
        test.display(10, 20);
    }
}
