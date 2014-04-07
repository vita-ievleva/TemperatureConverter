package dp.ievleva.logic;


import java.util.regex.*;

public class Validator {

    private static final Pattern P = Pattern.compile("^-?\\d+\\.?\\d*$");

    public static boolean isValid(String input) {

        Matcher m = P.matcher(input);
        return m.matches();

    }
}
