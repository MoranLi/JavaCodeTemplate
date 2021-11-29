package Sorting;

import java.util.*;

public class BucketSort {
    public static HashMap<Character, Integer> bucketSort(String s){
        HashMap<Character, Integer> bucket = new HashMap<>();
        for(int i =0; i < s.length(); i ++){
            bucket.put(s.charAt(i),bucket.getOrDefault(s.charAt(i), 0)+1);
        }
        return bucket;
    }
    public static String frequencySort(String s){
        HashMap<Character, Integer> bucket = bucketSort(s);
        HashMap<Integer, List<Character>> freq2Char = new HashMap<>();
        for(Character c: bucket.keySet()){
            Integer freq = bucket.get(c);
            List<Character> chars = freq2Char.getOrDefault(freq, new LinkedList<>());
            chars.add(c);
            freq2Char.put(freq, chars);
        }
        LinkedList<Integer> decreasingFrequency = new LinkedList<Integer>(freq2Char.keySet());
        Collections.sort(decreasingFrequency);
        StringBuilder sb = new StringBuilder();
        for(int i = decreasingFrequency.size() -1; i > -1; i --){
            List<Character> chars = freq2Char.get(decreasingFrequency.get(i));
            for(Character c : chars){
                for(int j = 0; j < decreasingFrequency.get(i); j ++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }
}
