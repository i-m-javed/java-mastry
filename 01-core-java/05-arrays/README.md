Topics Covered:

- Introduction to arrays
- Declaration & initialization
- Traversing arrays
- Taking input in arrays
- Sum & average
- Min & max
- Searching
- 2D arrays
- passing array



# Core Java - Arrays

## 1. Introduction to Arrays

An array is a collection of elements of the same data type stored in contiguous memory locations.

Arrays allow us to store multiple values in a single variable instead of creating separate variables.

Example:
int[] numbers = {10, 20, 30, 40};

---

## 2. Why Arrays?

Without array:
int a = 10;
int b = 20;
int c = 30;

With array:
int[] arr = {10, 20, 30};

Advantages:
- Better memory management
- Easy traversal using loops
- Useful for algorithms and data structures

---

## 3. Array Declaration

### Method 1
int[] arr;

### Method 2
int arr[];

Both are valid, but first is preferred.

---

## 4. Array Initialization

### Static Initialization
int[] arr = {1, 2, 3, 4};

### Dynamic Initialization
int[] arr = new int[5];

Default values:
- int → 0
- double → 0.0
- boolean → false
- char → '\u0000'
- Object → null

---

## 5. Accessing Elements

Array indexing starts from 0.

int[] arr = {10, 20, 30};
System.out.println(arr[0]);  // 10

Accessing invalid index throws:
ArrayIndexOutOfBoundsException

---

## 6. Traversing an Array

### Using for loop

for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

### Using for-each loop

for (int num : arr) {
    System.out.println(num);
}

Note:
- for-each is used only for reading
- Cannot modify index directly

---

## 7. Taking Input in Array

Scanner sc = new Scanner(System.in);
int[] arr = new int[3];

for(int i = 0; i < arr.length; i++){
    arr[i] = sc.nextInt();
}

---

## 8. Common Array Operations

### Sum of elements
int sum = 0;
for(int num : arr){
    sum += num;
}

### Average
double avg = (double) sum / arr.length;

### Find Maximum
int max = arr[0];
for(int num : arr){
    if(num > max){
        max = num;
    }
}

### Find Minimum
int min = arr[0];
for(int num : arr){
    if(num < min){
        min = num;
    }
}

---

## 9. Searching in Array

### Linear Search

int key = 30;
boolean found = false;

for(int num : arr){
    if(num == key){
        found = true;
        break;
    }
}

Time Complexity: O(n)

---

## 10. Passing Array to Method

Arrays are passed by value (reference value).

Example:

public static void modify(int[] arr){
    arr[0] = 999;
}

Original array gets modified because reference is shared.

---

## 11. Returning Array from Method

public static int[] createArray(){
    int[] arr = {1, 2, 3};
    return arr;
}

---

## 12. 2D Arrays

2D array is an array of arrays.

Declaration:
int[][] matrix = new int[2][3];

Static Initialization:
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};

Traversal:

for(int i = 0; i < matrix.length; i++){
    for(int j = 0; j < matrix[i].length; j++){
        System.out.print(matrix[i][j] + " ");
    }
}

---

## 13. Memory Representation

1D Array:
Stored in heap memory.
Variable holds reference.

2D Array:
Array of array references.

---

## 14. Advantages of Arrays

- Fast access using index (O(1))
- Easy traversal
- Memory efficient for fixed-size data

---

## 15. Limitations of Arrays

- Fixed size
- Same data type only
- Insertion/deletion costly
- No built-in dynamic resizing

---
## 16. Time Complexity Summary

Access element → O(1)
Traversal → O(n)
Linear search → O(n)
