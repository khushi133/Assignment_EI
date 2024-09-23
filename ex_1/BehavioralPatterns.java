import java.util.ArrayList;
import java.util.List;

// Observer Pattern
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature; // in Celsius

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

interface Observer {
    void update(int temperature);
}

class Display implements Observer {
    @Override
    public void update(int temperature) {
        double kelvin = temperature + 273.15; // Convert Celsius to Kelvin
        System.out.println("Temperature updated: " + kelvin + " K");
    }
}

// Strategy Pattern
interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class BehavioralPatterns {
    public static void main(String[] args) {
        // Observer Pattern Demo
        WeatherStation station = new WeatherStation();
        Display display = new Display();
        station.addObserver(display);
        station.setTemperature(25);
        station.setTemperature(30);

        // Strategy Pattern Demo
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}
