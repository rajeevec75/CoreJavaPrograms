class Animal{
    void eat(){System.out.println("eating");}
}
class Dog extends Animal{
    void run(){System.out.println("running");}
}
class Puppy extends Dog{
    void puppy(){System.out.println("puppy");}
}
public class MULTILEVEL_INHERITANCE{
    public static void main (String args[]){
        Puppy puppy = new Puppy();
        puppy.puppy();
        puppy.eat();
        puppy.run();
    }
}
