import java.util.*;

public class an {

    public static void main(String[] args) {
        amoritised();
        accounting();  
        
        potential();      
    }

    public static void potential() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[1];
        int[] size = new int[n];
        int[] total_cost = new int[n];
        int[] push_cost = new int[n];
        int[] double_cost = new int[n];
        int[] potential = new int[n];
        int[] a = new int[n];
        int counter = 0;
        for (int i = 0; i < n; i ++) {
            int cost = 1;
            counter++;
            push_cost[i] = cost;
            if (arr.length < counter) {
                double_cost[i] = arr.length;
                cost += arr.length;
                arr = doubleArray(arr);  
            } 
            arr[i] = 1;
            total_cost[i] = cost;
            size[i] = arr.length;
        }
        for (int i = 0; i < n; i++) {
            potential[i] = (2 * (i+1)) - size[i]; 
            if (i == 0) {
                a[i] = total_cost[i] + potential[i];
            } else {
                a[i] = total_cost[i] + potential[i] - potential[i-1];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print("\n" + (i+1) + "\t" + size[i] + "\t" + push_cost[i] + "\t" + double_cost[i] + "\t" + total_cost[i] + "\t" + potential[i] + "\t" + a[i]);
        }
    }

    public static void accounting() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[1];
        int[] size = new int[n];
        int[] total_cost = new int[n];
        int[] push_cost = new int[n];
        int[] double_cost = new int[n];
        int[] bank = new int[n];
        int counter = 0;
        for (int i = 0; i < n; i ++) {
            int cost = 1;
            counter++;
            push_cost[i] = cost;
            if (arr.length < counter) {
                double_cost[i] = arr.length;
                cost += arr.length;
                arr = doubleArray(arr);  
            } 
            arr[i] = 1;
            total_cost[i] = cost;
            size[i] = arr.length;
        }
        int sum = sum(total_cost);
        int amoritised_cost = (int)Math.ceil((float)sum / (float) n);
        for (int i = 0; i < n; i++) {
            int temp = 0;
            if (i != 0) {
                temp = bank[i-1];
            }
            bank[i] = temp + amoritised_cost - total_cost[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print("\n" + (i+1) + "\t" + size[i] + "\t" + push_cost[i] + "\t" + double_cost[i] + "\t" + total_cost[i] + "\t" + amoritised_cost + "\t" + bank[i]);
        }
    }

    public static void amoritised() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[1];
        int[] total_cost = new int[n];
        int counter = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i ++) {
            System.out.println("\nStep " + (i+1));
            int count = 0;
            counter++;
            if (arr.length < counter) {
                count += arr.length;
                arr = doubleArray(arr);
                arr[counter-1] = 1;
                count += 1;
            } else {
                count += 1;
                arr[counter-1] = 1;
            }
            total_cost[counter-1] = count;
            System.out.println("Cost: " + count);
            System.out.print("Array: ");
            printArray(arr);
            System.out.print("\nCost Array: ");
            printArray(total_cost);
            System.out.println("\nAmortised cost for this step: " + ((float)sum(total_cost)/counter));
        }
        long end = System.currentTimeMillis();
        System.out.println("\nTime required for array with " + n + " elements: " + (end - start) + "ms");
    }  

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] doubleArray(int[] arr) {
        int[] brr = new int[(arr.length * 2)];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        return brr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}