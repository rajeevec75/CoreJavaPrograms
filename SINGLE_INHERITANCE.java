class Animal{
    void eat(){System.out.println("eating");}
}
class Dog extends Animal{
    void run(){System.out.println("running");}
}

public class SINGLE_INHERITANCE{
    public static void main (String args[]){
        Dog dog = new Dog();
        dog.eat();
        dog.run();
    }
}



