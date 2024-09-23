// Singleton Pattern
class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Factory Method Pattern
interface Animal {
    void speak();
}

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow");
    }
}

abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

public class CreationalPatterns {
    public static void main(String[] args) {
        // Singleton Pattern Demo
        Logger logger = Logger.getInstance();
        logger.log("Singleton Pattern Example");

        // Factory Method Pattern Demo
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.speak();

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.speak();
    }
}
