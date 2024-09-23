import java.util.ArrayList;
import java.util.List;

// Adapter Pattern
interface Bird {
    void fly();
}

class Sparrow {
    public void makeSound() {
        System.out.println("Chirp");
    }
}

class SparrowAdapter implements Bird {
    private Sparrow sparrow;

    public SparrowAdapter(Sparrow sparrow) {
        this.sparrow = sparrow;
    }

    @Override
    public void fly() {
        sparrow.makeSound();
        System.out.println("Sparrow flying");
    }
}

// Composite Pattern
interface Graphic {
    void draw();
}

class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class GraphicGroup implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

public class StructuralPatterns {
    public static void main(String[] args) {
        // Adapter Pattern Demo
        Sparrow sparrow = new Sparrow();
        Bird bird = new SparrowAdapter(sparrow);
        bird.fly();

        // Composite Pattern Demo
        Graphic circle = new Circle();
        Graphic square = new Square();
        GraphicGroup group = new GraphicGroup();
        group.add(circle);
        group.add(square);
        group.draw();
    }
}
