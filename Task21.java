import java.util.Scanner;

public class Task21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] range = new int[n];
        for (int i = 0; i < n; i++) {
            range[i] = scanner.nextInt();
        }

        int max = Max(range);
        for (int i = 0; i < n; i++) {
            if (range[i] == max) {
                range[i] = range[i]/2;
            }
        }
        int max1 = Max(range);
        for (int i = 0; i < n; i++) {
            if (range[i] == max1) {
                range[i] = range[i]/2;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(range[i] + " ");
        }
    }

    private static int Max (int[] arr) {
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}