public interface IParkingService {
  String VEHICLE_REGEX_PATTERN = "^[A-Z]{2}\\-[0-9]{2}\\-[A-Z]{2}\\-[0-9]{4}$";
  Integer LENGTH_OF_VEHICLE_NUMBER = 13;
  
  void createParkingLot(int size);

  void parkNewVehicle(String vehicleNumber, int age);

  void getSlotNumberByDriverAge(int age);

  void getSlotNumberByVehicleNumber(String vehicleNumber);

  void upParkVehicleBySlotNumber(int slotNumber);

  void getVehicleNumberDetailsByAge(int age);
}