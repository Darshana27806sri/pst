import java.util.Scanner;
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}
class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Driver extends Person {
    public Driver(String name) {
        super(name);
    }
}

class Rider extends Person {
    public Rider(String name) {
        super(name);
    }
}

abstract class Vehicle {
    private String vehicleType;

    public Vehicle(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public abstract double getRatePerKm();
}

class Bike extends Vehicle {
    public Bike() {
        super("Bike");
    }

    @Override
    public double getRatePerKm() {
        return 5.0;
    }
}

class Auto extends Vehicle {
    public Auto() {
        super("Auto");
    }

    @Override
    public double getRatePerKm() {
        return 12.0;
    }
}

class Cab extends Vehicle {
    public Cab() {
        super("Cab");
    }

    @Override
    public double getRatePerKm() {
        return 12.0;
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) throws InvalidBookingException {
        if (type == null) {
            throw new InvalidBookingException("Invalid ride type.");
        }
        switch (type.trim().toLowerCase()) {
            case "bike":
                return new Bike();
            case "auto":
                return new Auto();
            case "cab":
                return new Cab();
            default:
                throw new InvalidBookingException("Unsupported vehicle type: " + type);
        }
    }
}

class Trip {
    private Rider rider;
    private Driver driver;
    private Vehicle vehicle;
    private double distance;

    public Trip(Rider rider, Driver driver, Vehicle vehicle, double distance) throws InvalidBookingException {
        if (distance <= 0) {
            throw new InvalidBookingException("Distance must be greater than 0.");
        }
        this.rider = rider;
        this.driver = driver;
        this.vehicle = vehicle;
        this.distance = distance;
    }

    public double calculateFare() {
        return distance * vehicle.getRatePerKm();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();

        Rider defaultRider = new Rider("DefaultRider");
        Driver defaultDriver = new Driver("DefaultDriver");

        for (int i = 0; i < n; i++) {
            String rideType = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle = VehicleFactory.createVehicle(rideType);
                Trip trip = new Trip(defaultRider, defaultDriver, vehicle, distance);
                System.out.println((long) trip.calculateFare());
            } catch (InvalidBookingException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}