public class DepreceatedLegacy {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); 
        api.newFeature();
    }
}

class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the old feature. It should not be used anymore.");
    }

    public void newFeature() {
        System.out.println("This is the new feature. Please use this instead.");
    }
}