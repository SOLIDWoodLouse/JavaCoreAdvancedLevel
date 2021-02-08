package lesson03;

import java.util.HashMap;

public class UniqueWord {

    private final HashMap<String, Integer> wordsHashMap = new HashMap<>();

    public HashMap<String, Integer> wordsHashMap(String[] words) {
        for (String x : words) {
            wordsHashMap.put(x, wordsHashMap.getOrDefault(x,0)+1);
        }
        return wordsHashMap;
    }

}
