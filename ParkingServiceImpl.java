import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ParkingServiceImpl implements IParkingService {
    private ParkingLot[] parkingLots;
    private Integer remainingSlots;

    public ParkingServiceImpl() {
      this.remainingSlots = 0;
    }
    @Override
    public void createParkingLot(int size) {
        parkingLots = new ParkingLot[size];
        remainingSlots = size;
    }

    @Override
    public void parkNewVehicle(String vehicleNumber, int age) {
        boolean isValid = validateData(vehicleNumber, age);
        if (isValid) {
            int slotNumber = getVacantSlotNumber();
            if (slotNumber >= 0) {
                parkingLots[slotNumber] = new ParkingLot(slotNumber + 1, vehicleNumber, age);
                System.out.println("Car with vehicle registration number \"" + vehicleNumber + "\" has been parked at slot number " + (slotNumber + 1));
            } else {
                System.out.println("Slots are not available for Parking");
            }
        }
    }

    @Override
    public void getSlotNumberByDriverAge(int age) {
        String collect = Arrays.stream(parkingLots).filter(pl -> pl != null).map(ParkingLot::getNumber).map(p -> p.toString()).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Override
    public void getSlotNumberByVehicleNumber(String vehicleNumber) {
        Optional<ParkingLot> parkingLot = Arrays.stream(parkingLots).filter(pl -> pl != null && pl.getVehicleNumber().equals(vehicleNumber)).findFirst();
        if (parkingLot.isPresent())
            System.out.println(parkingLot.get().getNumber());
        else
            System.out.println("Not parked");
    }

    @Override
    public void upParkVehicleBySlotNumber(int slotNumber) {
        if (slotNumber < 1 || slotNumber > parkingLots.length)
            System.out.println("Invalid Slot Number");
        else {
            ParkingLot parkingLot = parkingLots[slotNumber - 1];
            parkingLots[slotNumber - 1] = null;
            System.out.println("Slot number " + slotNumber + " vacated, the car with vehicle registration number \"" + parkingLot.getVehicleNumber() + "\" left the space, the driver of the car was of age " + parkingLot.getAge());
        }
    }

    @Override
    public void getVehicleNumberDetailsByAge(int age) {
        String nameOfVehicles = Arrays.stream(parkingLots).filter(pl -> pl != null && pl.getAge() == age).map(ParkingLot::getVehicleNumber).collect(Collectors.joining(","));
        if (nameOfVehicles.length() >= LENGTH_OF_VEHICLE_NUMBER)
            System.out.println(nameOfVehicles);
        else
            System.out.println("No any vehicle with driver age " + age);
    }

    private boolean validateData(String vehicleNumber, int age) {
        boolean isVehicleNumberValid = Pattern.matches(VEHICLE_REGEX_PATTERN, vehicleNumber);
        if (!isVehicleNumberValid)
            System.out.println("Invalid Vehicle number");
        boolean isAgeValid = age >= 18;
        if (!isAgeValid)
            System.out.println("Invalid age group");
        return isVehicleNumberValid && isAgeValid;
    }

    private int getVacantSlotNumber() {
        if (remainingSlots > 0) {
            for (int i = 0; i < parkingLots.length; i++) {
                if (parkingLots[i] == null)
                    return i;
            }
        }
        return -1;
    }
}
