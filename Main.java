public class Main {

    public static void main (String arg[]) {
        int n = 10;
        int [] array = CreatRand(n,10);

        System.out.println("max = " + Max(array));
        System.out.println("min = " + Min(array));
        System.out.println("avg = " + Avg(array));
        Sort(array);
        Print(array);
        array = RemoveElem(array,7);
        Print(array);
        PrimeNum(-5,10);
    }

    private static int[] CreatRand (int n, int decPartNum) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random() * decPartNum);
        }
        return arr;
    }

    private static void Print(int [] arr) {
        for (int i = 0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static int Max (int[] arr) {
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int Min (int[] arr) {
        int min = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    private static double Avg (int[] arr) {
        int avg = arr[0];
        for (int i = 0; i<arr.length; i++) {
            avg += arr[i];
        }
        return (double)avg/(double)arr.length;
    }

    private static void Sort (int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //return arr;
    }


    private static void PrimeNum (int start, int end) {
        if (start < 2)
            start = 2;
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;
            for(int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static int[] RemoveElem (int[] arr, int val) {
        int l = arr.length;
        int countVal = 0;

        for (int i = 0; i < l; i++) {
            if (arr[i] == val) {
                countVal++;
            }
            else {
                arr[i-countVal] = arr[i];
            }
        }

        int[] newArr = new int[l - countVal];
        for (int i = 0; i < l - countVal; i++) {

            newArr[i] = arr[i];
        }
        return newArr;
    }
}
