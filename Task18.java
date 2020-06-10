import java.util.Scanner;

public class Task18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] range = new int[n];
        for (int i = 0; i < n; i++) {
            range[i] = scanner.nextInt();
        }

        int i = 0;
        int sum = 0;
        int countP = 1;
        int countO = 2;
        while (i < n) {
            for (int j = 0; j < countP; j++) {
                if (i >= n)
                    break;
                sum += range[i];
                i++;
            }
            countP += 2;
            for (int j = 0; j < countO; j++) {
                if (i >= n)
                    break;
                sum -= range[i];
                i++;
            }
            countO += 2;
        }
        System.out.println(sum);
    }
}
