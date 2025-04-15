class Animal{
    void eat(){System.out.println("eating");}
}
class Dog extends Animal{
    void run(){System.out.println("running");}
}
class Cat extends Animal{
    void meow(){System.out.println("cat is meow");}
}
public class HIERARCHICAL_INHERITANCE{
    public static void main(String args[]){
        Cat  cat = new Cat();
        cat.eat();
        cat.meow();
        Dog dog = new Dog();
        dog.eat();
        dog.run();
    }
}
