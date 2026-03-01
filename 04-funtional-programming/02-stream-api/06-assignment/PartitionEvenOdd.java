import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitionEvenOdd {
    static void main() {
        int[] arr = {1, 3, 5, 4, 2, 7, 5, 8};

        Map<String, List<Integer>> ans = Arrays.stream(arr)
                .boxed()
                .collect(Collectors
                        .groupingBy(num -> num % 2 == 0 ? "even" : "odd"));
        
        System.out.println(ans);
    }
}
