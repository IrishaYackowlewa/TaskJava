import java.util.Scanner;

public class Task33 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] range = new int[n];
        for (int i = 0; i < n; i++) {
            range[i] = in.nextInt();
        }

        range[n-1]++;
        if (range[n-1] >= 10) {
            for (int i = n-1; i > 0; i--){
                if (range[i] >= 10){
                    range[i] = 0;
                    range[i-1]++;
                }
            }
        }
        if (range[0] >= 10) {
            int[] new_range = new int[n+1];
            for (int i = n-1; i > 0; i--){
                new_range[i+1] = range[i];
            }
            new_range[0] = 1;
            System.out.println(new_range.length);
            for (int i = 0; i < new_range.length; i++) {
                System.out.print(new_range[i] + " ");
            }
        }
        else {
            System.out.println(range.length);
            for (int i = 0; i < range.length; i++) {
                System.out.print(range[i] + " ");
            }

        }
    }
}
