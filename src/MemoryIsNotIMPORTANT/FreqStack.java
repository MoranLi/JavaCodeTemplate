package MemoryIsNotIMPORTANT;

import java.util.*;
public class FreqStack {

    HashMap<Integer, Stack<Integer>> freqMap;
    HashMap<Integer, Integer> numsMap;
    int maxFreq;

    public FreqStack() {
        freqMap = new HashMap<>();
        numsMap = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = numsMap.getOrDefault(val, 0) + 1;
        numsMap.put(val, freq);
        Stack<Integer> nums = freqMap.getOrDefault(freq, new Stack<>());
        nums.push(val);
        freqMap.put(freq, nums);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> nums = freqMap.get(maxFreq);
        int val = nums.pop();
        if(nums.size() == 0) {
            maxFreq--;
        }
        numsMap.put(val, maxFreq);
        return val;
    }

    public static void main(String[] args) {
        FreqStack f = new FreqStack();
        f.push(5);
        f.push(7);
        f.push(5);
        f.push(7);
        f.push(4);
        f.push(5);
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
        System.out.println(f.pop());
    }
}
