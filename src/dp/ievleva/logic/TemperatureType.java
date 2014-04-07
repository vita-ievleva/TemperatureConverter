package dp.ievleva.logic;

public enum TemperatureType {
    F("°F"), C("°C");

    private final String type;

     TemperatureType(String type) {
        this.type = type;
     }

    public String getTempType() {
        return type;

    }


}
