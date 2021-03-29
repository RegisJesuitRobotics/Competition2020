package frc.robot.utils;

public class Util {
    private Util() {}

    /**
     * This will take any number -infinity to infinity and simplify it to 0-359
     * @param originalAngle the angle to simplify
     * @return the simplified angle
     */
    public static int simplifyAngle(int originalAngle) {
        if (originalAngle > 0) {
            return originalAngle % 360;
        } else if (originalAngle < 0) {
            return 360 + (originalAngle % 360);
        }
        return 0;
    }
    /**
     * Gets the fastest direction to get from one angle to another
     * @param originalAngle 0-359
     * @param destinationAngle 0-359
     * @return -1 or 1
     */
    public static int getFastestDirection(double originalAngle, double destinationAngle) {
        System.out.println(originalAngle);
        System.out.println(destinationAngle);
        double difference1 = originalAngle - destinationAngle;
        double difference2 = destinationAngle - originalAngle;
        if (difference2 < 180 && difference2 >= 0) {
            return 1;
        }
        if (difference1 < 180 && difference1 >= 0) {
            return -1;
        }
        if (difference1 < difference2) {
            return -1;
        }
        return 1;
    }

    /**
     * calculates if an angle is within a given range
     * @param range1 the first parameter of the range
     * @param range2 the second parameter of the range
     * @param angle the angle to calculate with
     * @return if it is in the angle
     */
    public static boolean isInAngleRange(double range1, double range2, double angle) {
        if (range1 > range2) {
            if (angle >= range1) {
                return true;
            }
            return angle >= 0 && angle < range2;
        }
        return angle >= range1 && angle <= range2;
    }
}