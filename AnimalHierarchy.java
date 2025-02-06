class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}


class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}


class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}


public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy", 3); // Upcasting
        Animal cat = new Cat("Whiskers", 2); // dynamic method dispatch
        Animal bird = new Bird("Tweety", 1); // runtime polymorphism

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}