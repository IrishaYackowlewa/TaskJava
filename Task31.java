import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Task31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] range = new int[n];
        for (int i = 0; i < n; i++) {
            range[i] = scanner.nextInt();
        }

        SortedSet<Integer> elemArrSet = new TreeSet();
        SortedSet<Integer> elemArrUnunicSet = new TreeSet();
        for (int i = 0; i < n; i++) {
            if(!elemArrSet.add(range[i])) {
                elemArrUnunicSet.add(range[i]);
            };
        }

        int size = elemArrUnunicSet.size();
        if (size == 0) {
            System.out.println(size);
            System.out.println();
        }
        else {
            System.out.println(size);
            for (int val: elemArrUnunicSet) {
                System.out.print(val + " ");
            }
        }
    }
}