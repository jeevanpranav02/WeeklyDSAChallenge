package Day_3;

public class AngleBetweenHandsOfClock {
    public static void main(String[] args) {
        int hour = 11;
        int minutes = 59;
        System.out.println(angleClock(hour, minutes));
    }

    static double angleClock(int hour, int minutes) {
        double minuteAngle = ((double) minutes / 60) * 360;
        double hourAngle = ((double) (hour % 12)) * (360 / 12) + (minuteAngle / 12);
        double angle = Math.abs(minuteAngle - hourAngle);
        return angle > 180 ? 360 - angle : angle;
    }
}
