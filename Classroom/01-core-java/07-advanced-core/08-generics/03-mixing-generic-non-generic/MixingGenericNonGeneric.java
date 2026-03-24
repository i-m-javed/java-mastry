import java.util.ArrayList;
import java.util.List;

public class MixingGenericNonGeneric {

    public static void main(String[] args) {

        System.out.println("==== DIRECT MIXING DEMO ====");
        directMixingDemo();

        System.out.println("\n==== METHOD PARAMETER CORRUPTION ====");
        methodCorruptionDemo();

        System.out.println("\n==== SAFE LEGACY HANDLING ====");
        safeHandlingDemo();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void directMixingDemo() {

        List<String> typedList = new ArrayList<>();
        typedList.add("Java");

        List rawList = typedList;  // Mixing occurs
        rawList.add(100);          // Compiles, corrupts list

        try {
            for (String value : typedList) {
                System.out.println(value);
            }
        } catch (ClassCastException e) {
            System.out.println("Runtime failure due to heap pollution!");
        }
    }

    private static void methodCorruptionDemo() {

        List<String> stringList = new ArrayList<>();
        stringList.add("Spring");

        corruptList(stringList);  // Pass generic list to raw method

        try {
            String value = stringList.get(1);
            System.out.println(value);
        } catch (ClassCastException e) {
            System.out.println("Method corrupted generic list!");
        }
    }

    // Dangerous raw method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void corruptList(List list) {
        list.add(500);
    }

    private static void safeHandlingDemo() {

        List<?> safeList = getLegacyList();

        System.out.println("Safe read-only access:");
        for (Object obj : safeList) {
            System.out.println(obj);
        }

        // safeList.add("Test"); // Not allowed (good protection)
    }


    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static List getLegacyList() {
        List raw = new ArrayList();
        raw.add("Legacy Data");
        raw.add(123);
        return raw;
    }
}