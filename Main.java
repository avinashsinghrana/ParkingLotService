import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        IParkingService parkingService = new ParkingServiceImpl();
        while (reader.ready()) {
            String[] input = reader.readLine().split(" ");
            switch (input[0]) {
                case "Create_parking_lot":
                    parkingService.createParkingLot(Integer.parseInt(input[1]));
                    break;
                case "Park":
                    parkingService.parkNewVehicle(input[1], Integer.parseInt(input[3]));
                    break;
                case "Slot_numbers_for_driver_of_age":
                    parkingService.getSlotNumberByDriverAge(Integer.parseInt(input[1]));
                    break;
                case "Vehicle_registration_number_for_driver_of_age":
                    parkingService.getVehicleNumberDetailsByAge(Integer.parseInt(input[1]));
                    break;
                case "Leave":
                    parkingService.upParkVehicleBySlotNumber(Integer.parseInt(input[1]));
                    break;
                case "Slot_number_for_car_with_number":
                    parkingService.getSlotNumberByVehicleNumber(input[1]);
                    break;
            }
        }
    }
}