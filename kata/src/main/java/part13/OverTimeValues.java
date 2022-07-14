package part13;

public enum OverTimeValues {
    THREE_HOUR,
    FIVE_HOUR,
    WEEKEND_FOUR_HOUR,
    WEEKEND_EIGHT_HOUR;

    String a;

    public static void main(String[] args) {
        System.out.println(OverTimeValues.THREE_HOUR.hashCode());
        System.out.println(OverTimeValues.THREE_HOUR.hashCode());
        System.out.println(OverTimeValues.THREE_HOUR.hashCode());
    }
}
