// Superclass
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Subclass Cat
class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

// Main class to demonstrate polymorphism
public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Dynamic binding
        Animal myCat = new Cat(); // Dynamic binding

        myDog.sound(); // Outputs: Dog barks
        myCat.sound(); // Outputs: Cat meows

        // Using an array of Animals
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal animal : animals) {
            animal.sound(); // Outputs: Dog barks, Cat meows
        }
    }
}