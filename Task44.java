import java.io.*;

public class Task44 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String sCountWord = bufferedReader.readLine();
        int countWord = Integer.parseInt(sCountWord);
        String[][] array = new String[countWord][2];
        for (int i = 0; i < countWord; i++){
            array[i] = bufferedReader.readLine().split(" ");
        }
        String str = bufferedReader.readLine();

        System.out.println(decoderHuffman(str, array, countWord));

    }

    private static String decoderHuffman (String s, String[][] arr, int countW) {

        StringBuilder new_s = new StringBuilder("");
        for (int i = 0; i < s.length(); i++){

            for (int k = 0; k < countW; k++){

                int lenElemArr = arr[k][1].length();
                if ((i + lenElemArr) <= s.length()) {

                    if (arr[k][1].equals(s.substring(i, i + lenElemArr))) {
                        new_s.append(arr[k][0]);
                        i = i + lenElemArr - 1;
                        break;
                    }
                }
            }
        }
        return new_s.toString();
    }
}