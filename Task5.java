import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

            int[] range = new int[n];
            for (int i = 0; i < n; i++) {
                range[i] = scanner.nextInt();
            }

            int min = Min(range);
            for (int i = 0; i < range.length; i++) {
                if (range[i] == min) {
                    System.out.print(i + 1);
                    break;
                }
            }
    }

    private static int Min (int[] arr) {
        int min = arr[0];
        for (int value : arr) {
            if (value < min)
                min = value;
        }
        return min;
    }
}