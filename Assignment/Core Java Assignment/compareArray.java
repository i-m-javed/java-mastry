package training;
import java.util.Scanner;
public class compareArray {
	public static void main(String[] args) {
//		ArrayList<Integer> arr1= new ArrayList<>();
//		ArrayList<Integer> arr2= new ArrayList<>();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array1");
		int len1= sc.nextInt();
		System.out.println("Enter size of array2");
		int len2= sc.nextInt();
		int arr1[]= new int[len1];
		int arr2[]= new int[len2];
		System.out.println("Enter values of array 1");
		for(int i=0;i<len1;i++) {
			arr1[i]=sc.nextInt();
		}
		System.out.println("Enter values of array 2");
		for(int i=0;i<len1;i++) {
			arr2[i]=sc.nextInt();
		}
		
		if(len1!=len2) {
			System.out.println("Both arrays are not equal");
		} else {
			for(int i=0;i<len1;i++) {
				if(arr1[i]!=arr2[i]) {
					System.out.println("Both arrays are not equal");
					return;
				}
			}
		}
		System.out.println("Both arrays are equal");
	}
}
