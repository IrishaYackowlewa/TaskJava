import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer,Integer> multiset = new TreeMap<>();
        int countOper = in.nextInt();
        for (int i = 0; i < countOper; i++){
            int oper = in.nextInt();

            switch(oper) {
                case 1:
                    int elem = in.nextInt();
                    if (multiset.containsKey(elem)){
                        multiset.put(elem,(1 + multiset.get(elem)));
                    }
                    else{
                        multiset.put(elem,1);
                    }
                    break;
                case 2:
                    if (!multiset.isEmpty()){
                        System.out.println(multiset.firstEntry().getKey());
                        multiset.put(multiset.firstEntry().getKey(),multiset.firstEntry().getValue()-1);
                        if (multiset.firstEntry().getValue().equals(0)){
                            multiset.pollFirstEntry();
                        }
                    }
                    break;
            }
        }
    }
}