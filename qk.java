import java.util.*;

public class qk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int temp = random.nextInt(200) - 100;
            arr1[i] = temp;
            arr2[i] = temp;
        }
        long start1 = System.currentTimeMillis();
        System.out.println(start1);
        // print(arr1);
        quicksort(arr1, 0, arr1.length - 1, 0);
        // print(arr1);
        long end1 = System.currentTimeMillis();
         System.out.println(end1);
        System.out.println("Time for normal quick sort is: " + (end1 - start1));
        long start2 = System.currentTimeMillis();
        // print(arr2);
        quicksort(arr2, 0, arr2.length - 1, 1);
        // print(arr2);
        long end2 = System.currentTimeMillis();
        System.out.println("Time for randomised quick sort is: " + (end2 - start2));
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t\t");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int low, int high, int key) {
        if (key == 1) {
            random(arr, low, high);
        }
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i+1);
    }

    public static void random(int[] arr, int low, int high) {
        Random random = new Random();
        int temp = random.nextInt(high - low) + low;
        int i = arr[temp];
        arr[temp] = arr[high];
        arr[high] = i;
    }

    public static void quicksort(int[] arr, int low, int high, int key) {
        if (low < high) {
            int p = partition(arr, low, high, key);
            quicksort(arr, low, p-1, key);
            quicksort(arr, p+1, high, key);
        }
    }

}