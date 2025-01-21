public class L1_7 {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double radiusMiles = radiusKm * 0.621371;
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double volumeMiles3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);

        System.out.println("Volume of Earth in km^3: " + volumeKm3);
        System.out.println("Volume of Earth in miles^3: " + volumeMiles3);
    }
}
