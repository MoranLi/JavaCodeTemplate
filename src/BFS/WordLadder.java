package BFS;
import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)){
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        int step = 1;
        while(q.size() > 0){
            int n = q.size();
            for(int i = 0; i < n; i ++){
                String s = q.poll();
                if(s.equals(endWord)){
                    return step;
                }
                List<String> transfered = transfer(s, words);
                for(String t: transfered){
                    if(! visited.contains(t)){
                        q.add(t);
                        visited.add(t);
                    }
                }
            }
            step ++;
        }
        return 0;
    }
    public List<String> transfer(String s, HashSet<String> words){
        List<String> ans = new LinkedList<>();
        for(int i = 0; i < s.length(); i ++){
            StringBuilder sb = new StringBuilder(s.substring(0,i));
            for(int j = 0; j < 26; j ++){
                sb.append((char)('a' + j));
                sb.append(s.substring(i+1));
                String t= sb.toString();
                if(!t.equals(s) && words.contains(t)){
                    ans.add(t);
                }
                sb.delete(i, sb.length());
            }
        }
        return ans;
    }
}
