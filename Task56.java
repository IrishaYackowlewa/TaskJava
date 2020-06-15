import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("input.txt");
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

            Comparator<String> fileComp = new FileComparator();
            Map<String, Integer> countWords= new TreeMap<>(fileComp);
            for(String word: words){
                if (countWords.containsKey(word)){
                    countWords.put(word,(1 + countWords.get(word)));
                }
                else{
                    countWords.put(word,1);
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList(countWords.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            });

            ArrayList<String> lmax = new ArrayList();
            lmax.add(list.get(0).getKey());
            int i =0;
            while (list.get(i).getValue()==list.get(i+1).getValue() && i < list.size()){
                lmax.add(list.get(i+1).getKey());
                i++;
            }

            for (String word: lmax) System.out.println(word);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class FileComparator implements Comparator<String> {

        public int compare(String a, String b){

            return a.compareTo(b);
        }
    }
}