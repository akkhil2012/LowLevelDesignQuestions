public class Main {
    public static void main(String[] args) throws Exception {
        ParkingController parkingController = new ParkingController();


        Vehicle vehicle = new Vehicle("MH12JB");
        //park car:
       // Vehicle vehicle  = new Vehicle("MH12JB");
        parkingController.parkVehicle("MH12JB");

        System.out.println(" Vechicle Parked...");


        parkingController.unParkVahicle("MH12JB");


    }
}