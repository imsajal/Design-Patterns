package Practice.builder;

class Vehicle{


    private String engine;
    private Integer wheels;
    private Integer airbags;

    public String getEngine() {
        return engine;
    }

    public Integer getWheels() {
        return wheels;
    }

    public Integer getAirbags() {
        return airbags;
    }

    private Vehicle(VehicleBuilder vb){
        this.airbags = vb.airbags;
        this.wheels = vb.wheels;
        this.engine = vb.engine;
    }

    public static class VehicleBuilder{
        private String engine;
        private Integer wheels;
        private Integer airbags;

        VehicleBuilder(String engine, Integer wheels){
            this.engine = engine;
            this.wheels = wheels;
        }

        public VehicleBuilder setAirbags(Integer airbags){
            this.airbags = airbags;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}

public class BuilderPatternExample {

    public static void main(String[] args) {
       //
        Vehicle car = new Vehicle.VehicleBuilder("1000cc", 4).setAirbags(5).build();
        System.out.println(car.getAirbags());
        System.out.println(car.getWheels());
        System.out.println(car.getEngine());

        Vehicle bike = new Vehicle.VehicleBuilder("500cc", 2).build();
        System.out.println(bike.getAirbags());
        System.out.println(bike.getWheels());
        System.out.println(bike.getEngine());

    }
}