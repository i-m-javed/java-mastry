// Simple Enum
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

public class SimpleEnumDemo {

    public static void main(String[] args) {

        // Assigning enum value
        Day today = Day.FRIDAY;

        System.out.println("Today is: " + today);

        // Using enum in switch
        switch (today) {
            case MONDAY:
                System.out.println("Start of work week.");
                
                break;

            case FRIDAY:
                System.out.println("Weekend is near!");
                System.out.println(today.ordinal());
                System.out.println(today.name());
                break;

            case SUNDAY:
                System.out.println("Rest day.");
                break;

            default:
                System.out.println("Regular day.");
        }

        // Printing all enum values
        System.out.println("\nAll Days:");
        for (Day d : Day.values()) {
            System.out.println(d);
        }
    }
}