abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver Name: " + driverName + ", Rate per Km: " + ratePerKm;
    }

    public abstract double calculateFare(double distance);
}

class Car extends Vehicle {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

class Auto extends Vehicle {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle car = new Car("C123", "John Doe", 10.0);
        Vehicle bike = new Bike("B456", "Jane Smith", 5.0);
        Vehicle auto = new Auto("A789", "Bob Brown", 7.0);

        System.out.println(car.getVehicleDetails());
        System.out.println("Fare for 15 km: " + car.calculateFare(15));

        System.out.println(bike.getVehicleDetails());
        System.out.println("Fare for 15 km: " + bike.calculateFare(15));

        System.out.println(auto.getVehicleDetails());
        System.out.println("Fare for 15 km: " + auto.calculateFare(15));
    }
}