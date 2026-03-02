package Arrays;

import java.util.*;

public class ArrayConversionDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // Convert int array to List<Integer>

        List <Integer> list1 = new ArrayList<>(Arrays.asList(
                Arrays.stream(arr)
                        .boxed()
                        .toArray(Integer[]::new)));


        // Convert List<Integer> to int array option 1
        int[] arr2 = list1.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(list1);
        System.out.println(Arrays.toString(arr2));
    }
}
