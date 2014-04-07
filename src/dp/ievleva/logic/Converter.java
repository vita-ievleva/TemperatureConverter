package dp.ievleva.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {

    public static double degreeConvert (double degree, TemperatureType type) {
        double degreeNew = 0;

        switch (type) {
            case C: degreeNew = degree * (9.0 / 5) + 32;
                break;
            case F: degreeNew = (degree - 32) * (5.0 / 9);
                break;
        }
        return new BigDecimal(degreeNew).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
