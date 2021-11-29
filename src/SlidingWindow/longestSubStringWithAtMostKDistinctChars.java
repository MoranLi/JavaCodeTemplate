package SlidingWindow;

import java.util.*;

public class longestSubStringWithAtMostKDistinctChars {
    public int lengthOfLongestSubStringKDistinct(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for(int i = 0; i < s.length(); i ++){
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.size() > k){
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) map.remove(c);
                left ++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
