import java.util.Scanner;
import java.util.Arrays;

public class Task35 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] range = new int[n];
        for (int i = 0; i < n; i++) {
            range[i] = in.nextInt();
        }

        System.out.println(getPeriod(range).length);

    }

    private static int[] getPeriod (int[] arr) {
        int lenArr = arr.length;
        for (int i = 0; i < lenArr; i++) {
            if (lenArr % (i+1) != 0) {
                break;
            }
            else {
                int[] mbPeriod = Arrays.copyOfRange(arr, 0, i);
                int lenMbPeriod = mbPeriod.length;
                int partRight = 0;
                int countRightPart = lenArr / lenMbPeriod;
                for (int k = 0; k <= countRightPart; k = k + lenMbPeriod){
                    int[] partArr = Arrays.copyOfRange(arr, k, k+lenMbPeriod);
                    for (int j = 0; j < lenMbPeriod; j++){
                        if (mbPeriod[j] != partArr[j]){
                            break;
                        }
                        else {
                            partRight++;
                        }
                    }
                }
                if (partRight == countRightPart){
                    return mbPeriod;
                }
                else {
                    return arr;
                }
            }
        }
        return arr;
    }
}
