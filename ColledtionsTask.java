import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ColledtionsTask {
    public static void main(String[] args) throws IOException{
        //System.out.println(countWords("input.txt"));//1
        //wordsText ("input.txt");//2
        //countWordText("input.txt");//3
        //reverseRowOrder("input.txt");//4
        //linesRandomOrder("input.txt");//6

    }

    public static ArrayList<String> fileRead(String name) {
        try {
            File file = new File(name);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            ArrayList<String> words = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                line = line.trim().toLowerCase();
                if (!line.equals("")){
                    String[] wordsStr = line.split("[\\s\\W\\d_]+");
                    Collections.addAll(words, wordsStr);
                }
                line = reader.readLine();
            }
            return words;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countWords (String name){
        ArrayList<String> words = fileRead(name);
        HashSet<String> wordsSet = new HashSet<>();
        wordsSet.addAll(words);
        return wordsSet.size();
    }

    public static void wordsText (String name){
        ArrayList<String> words = fileRead(name);

        Comparator<String> fileComp = new FileLengthComparator().thenComparing(new FileComparator());
        TreeSet<String> wordsSet = new TreeSet<>(fileComp);

        wordsSet.addAll(words);
        for(Object word: wordsSet){
            System.out.println(word);
        }
    }

    static class FileLengthComparator implements Comparator<String> {

        public int compare(String a, String b){
            if(a.length() > b.length())
                return 1;
            else if(a.length() < b.length())
                return -1;
            else
                return 0;
        }
    }

    static class FileComparator implements Comparator<String> {

        public int compare(String a, String b){

            return a.compareTo(b);
        }
    }

    public static void countWordText (String name) {
        ArrayList<String> words = fileRead(name);

        Comparator<String> fileComp = new FileLengthComparator().thenComparing(new FileComparator());
        TreeMap<String, Integer> countWords= new TreeMap<>(fileComp);
        for(String word: words){
            if (countWords.containsKey(word)){
                countWords.put(word,(1 + countWords.get(word)));
            }
            else{
                countWords.put(word,1);
            }
        }

        for(Map.Entry<String, Integer> item : countWords.entrySet()){
            System.out.printf("%s: %s \n", item.getKey(), item.getValue());
        }
    }

    public static void reverseRowOrder(String name) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(name), StandardCharsets.UTF_8);
        ListIterator LIterator = lines.listIterator(lines.size());//просто обходит в обратном порядке
        while(LIterator.hasPrevious()){
            System.out.println(LIterator.previous());
        }
    }

    public static void linesRandomOrder(String name) {
        try {
            File file = new File(name);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            ArrayList<String> lines = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter line number or number <= 0 if you want to finish : ");
            int numLine = scanner.nextInt();
            while (numLine > 0){
                if (numLine <= lines.size()){
                    System.out.println(lines.get(numLine - 1));
                }
                else{
                    System.out.println("There is no such line");
                }
                System.out.println("Enter next line number: ");
                numLine = scanner.nextInt();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}