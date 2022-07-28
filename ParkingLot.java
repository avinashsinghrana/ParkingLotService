public class ParkingLot {
    private Integer number;
    private String vehicleNumber;
    private Integer age;

    public ParkingLot(Integer number, String vehicleNumber, int age) {
        this.number = number;
        this.vehicleNumber = vehicleNumber;
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
