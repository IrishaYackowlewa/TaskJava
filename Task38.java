import java.io.*;

public class Task38 {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = bufferedReader.readLine();

        System.out.println(countWordLongLet(str));

    }

    private static int countWordLongLet (String s) {
        String[] arrStr = s.split("[\\W\\d_]+");
        int max = 0;
        for (String elem: arrStr) {
            if (elem.length() > max)
                max = elem.length();
        }
        return max;
    }
}