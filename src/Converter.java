public class Converter {
    public static final int STEP_LENGTH_CM = 75;
    public static final int CENTIMETERS_IN_METER = 100;
    public static final int METERS_IN_KILOMETER = 1000;
    public static final int CALORIES_PER_STEP = 50;
    public static final int CALORIES_IN_KILOCALORIE = 1000;

    int convertToKm(int steps) {
        return steps * STEP_LENGTH_CM / CENTIMETERS_IN_METER / METERS_IN_KILOMETER;
    }

    int convertStepsToKilocalories(int steps) {
        return steps * CALORIES_PER_STEP / CALORIES_IN_KILOCALORIE;
    }
}
