 class Device {
    private String deviceId;
    private String status;

    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

 class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    public double getTemperatureSetting() {
        return temperatureSetting;
    }

    public void setTemperatureSetting(double temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting);
    }
}

public class SmartHome{
    public static void main(String[] args) {
        Device device = new Device("123", "On");
        device.displayStatus();
        System.out.println();

        Thermostat thermostat = new Thermostat("456", "Off", 72.5);
        thermostat.displayStatus();
    }
}