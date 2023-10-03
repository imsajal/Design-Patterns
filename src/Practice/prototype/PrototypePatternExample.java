package Practice.prototype;
import java.util.ArrayList;
import java.util.List;

class VehicleData implements Cloneable{

    List<String> vehicles;

    VehicleData(){
        vehicles = new ArrayList<>();
    }

    VehicleData(List<String> vehicles){
        this.vehicles = vehicles;
    }

    public List<String> getVehicles(){
        return this.vehicles;
    }

    @Override
    public Object clone(){
        List<String> clonedVehicleList = new ArrayList<>();

        for (String vehicle : vehicles){
            clonedVehicleList.add(vehicle);
        }

        return new VehicleData(clonedVehicleList);
    }



}

public class PrototypePatternExample {

    public static void main(String[] args) throws CloneNotSupportedException {


        //
        VehicleData vehicleData = new VehicleData();
        vehicleData.getVehicles().add("babu");
        vehicleData.getVehicles().add("shona");

        vehicleData.getVehicles().add("baby");

       VehicleData vehicleData1 =  (VehicleData) vehicleData.clone();

       vehicleData1.getVehicles().remove("baby");
       vehicleData1.getVehicles().add("sweety");

        System.out.println(vehicleData1.getVehicles());
        System.out.println(vehicleData.getVehicles());



    }

}