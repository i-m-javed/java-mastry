import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCount {
    public static Map<Integer, Long> getFrequency(int[] arr) {

        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
    }

    static void main() {
        int[] arr = {1, 2, 3, 1, 4, 2, 6, 9};

        System.out.println(Arrays.toString(arr) + " -> " + getFrequency(arr));
    }
}
