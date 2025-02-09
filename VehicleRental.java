import java.util.ArrayList;
import java.util.List;

enum TYPE {
    CAR, TRUCK, BIKE
}

interface Insurable {
    public float calculateInsurance();
    public String getInsuranceDetails();
}

abstract class Vehicle implements Insurable {
    private int vehicleNumber;
    private TYPE type;
    private float rentalRate;

    public Vehicle(int _id, TYPE _type, float _rate) {
        this.vehicleNumber = _id;
        this.type = _type;
        this.rentalRate = _rate;
    }

    public int getVehicleNumber() {
        return this.vehicleNumber;
    }

    public String getType() {
        return this.type.toString().toUpperCase();
    }

    public float getRentalRate() {
        return this.rentalRate;
    }

    public void setRentalRate(float _rate) {
        this.rentalRate = _rate;
    }

    public void setType(TYPE _type) {
        this.type = _type;
    }

    protected abstract float calculateRentalCost(int _days);

    @Override
    public abstract float calculateInsurance();

    @Override
    public abstract String getInsuranceDetails();
}

class Car extends Vehicle {
    private int numberOfSeats;

    public Car(int _id, TYPE _type, float _rate, int _seats) {
        super(_id, _type, _rate);
        this.numberOfSeats = _seats;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    @Override
    public float calculateRentalCost(int _days) {
        return this.getRentalRate() * _days;
    }

    @Override
    public float calculateInsurance() {
        return this.getRentalRate() * 0.1f;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: " + calculateInsurance();
    }
}

class Truck extends Vehicle {
    private float weightCapacity;

    public Truck(int _id, TYPE _type, float _rate, float _weight) {
        super(_id, _type, _rate);
        this.weightCapacity = _weight;
    }

    public float getWeightCapacity() {
        return this.weightCapacity;
    }

    @Override
    public float calculateRentalCost(int _days) {
        return this.getRentalRate() * _days;
    }

    @Override
    public float calculateInsurance() {
        return this.getRentalRate() * 0.2f;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: " + calculateInsurance();
    }
}

class Bike extends Vehicle {
    private boolean hasSideCar;

    public Bike(int _id, TYPE _type, float _rate, boolean _sideCar) {
        super(_id, _type, _rate);
        this.hasSideCar = _sideCar;
    }

    public boolean getHasSideCar() {
        return this.hasSideCar;
    }

    @Override
    public float calculateRentalCost(int _days) {
        return this.getRentalRate() * _days;
    }

    @Override
    public float calculateInsurance() {
        return this.getRentalRate() * 0.05f;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: " + calculateInsurance();
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(1, TYPE.CAR, 100, 4));
        vehicles.add(new Truck(2, TYPE.TRUCK, 200, 1000));
        vehicles.add(new Bike(3, TYPE.BIKE, 50, true));

        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Type: " + vehicle.getType());
            System.out.println("Rental Cost for 5 days: " + vehicle.calculateRentalCost(5));
            System.out.println(vehicle.getInsuranceDetails());
            System.out.println();
        }
    }
}