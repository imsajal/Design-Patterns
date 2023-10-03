package Practice;

abstract class Vehicle{

    public abstract int getWheel();

    @Override
    public String toString(){
        return ("Wheels are   " + this.getWheel());
    }
}

class Car extends Vehicle{
    Integer wheels;
    Car(int wheels){
        this.wheels = wheels;
    }
    @Override
    public int getWheel(){
        return this.wheels;
    }
}

class Bike extends Vehicle{
    Integer wheels;

    Bike(int wheels){
        this.wheels = wheels;
    }
    @Override
    public int getWheel(){
        return this.wheels;
    }
}

class VehicleFactory{

    public static Vehicle getInstance(String arg){

        if(arg.equalsIgnoreCase("bike")){
            return new Bike(2);
        }
        if(arg.equalsIgnoreCase("car")){
           return new Car(4);
        }
        return null;
    }
}

public class FactoryPatternExample {

    public static void main(String[] args) {

         Vehicle car = VehicleFactory.getInstance("car");
         System.out.println(car);
         Vehicle bike = VehicleFactory.getInstance("bike");
        System.out.println(bike);
    }

}