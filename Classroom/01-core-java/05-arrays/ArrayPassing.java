public class ArrayPassing {

    // ================= 1D ARRAY METHODS =================

    // 1. Print 1D array
    public static void print1D(int[] arr) {
        System.out.println("Printing 1D Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // 2. Modify 1D array
    public static void modify1D(int[] arr) {
        arr[0] = 999;   // modify first element
    }

    // 3. Return new 1D array
    public static int[] create1DArray() {
        int[] arr = {5, 10, 15};
        return arr;
    }

    // ================= 2D ARRAY METHODS =================

    // 4. Print 2D array
    public static void print2D(int[][] matrix) {
        System.out.println("Printing 2D Array:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 5. Modify 2D array
    public static void modify2D(int[][] matrix) {
        matrix[0][0] = 111;
    }

    // 6. Return new 2D array
    public static int[][] create2DArray() {
        int[][] matrix = {
                {7, 8},
                {9, 10}
        };
        return matrix;
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        // -------- 1D Array Demo --------
        int[] numbers = {10, 20, 30, 40};

        print1D(numbers);

        modify1D(numbers);  // reference modification

        System.out.println("After modifying 1D array:");
        print1D(numbers);

        int[] newArray = create1DArray();
        System.out.println("Returned 1D array:");
        print1D(newArray);


        System.out.println("-------------------------");


        // -------- 2D Array Demo --------
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        print2D(matrix);

        modify2D(matrix);  // reference modification

        System.out.println("After modifying 2D array:");
        print2D(matrix);

        int[][] newMatrix = create2DArray();
        System.out.println("Returned 2D array:");
        print2D(newMatrix);
    }
}