package Practice.observer;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObservers();
}

interface Observer{
    void update(String location);
}

class DeliveryManagement implements Subject{

    List<Observer> observers = new ArrayList<>();

    String  location;


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
       observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(this.location);
        }
    }

    public void locationChanged(String location){
        this.location = location;
        notifyObservers();
    }
}

class Seller implements Observer{

    String location;

    @Override
    public void update(String location) {
        this.location = location;
        System.out.println("Seller notified new location is " + location);
    }
}

class Client implements Observer{

    String location;

    @Override
    public void update(String location) {
        this.location = location;
        System.out.println("Client notified new location is " + location);
    }
}

class WareHouse implements Observer{

    String location;

    @Override
    public void update(String location) {
        this.location = location;
        System.out.println("WareHouse notified new location is " + location);
    }
}

public class ObserverPatternTest {

    public static void main(String[] args) {

        //
        DeliveryManagement deliveryManagement = new DeliveryManagement();
        deliveryManagement.register(new Seller());
        WareHouse wareHouse = new WareHouse();
        deliveryManagement.register(wareHouse);
        deliveryManagement.register(new Client());

        deliveryManagement.locationChanged("Gurgaon");

        deliveryManagement.unregister(wareHouse);

        deliveryManagement.locationChanged("Bangalore");
    }
}