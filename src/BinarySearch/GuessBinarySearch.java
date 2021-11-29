package BinarySearch;

public class GuessBinarySearch {
    // use it when the question seems like bfs
    // but we can verify a answer in O(n) time
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i ++){
            max = Math.max(max, piles[i]);
        }
        while (min < max){
            int mid = min + (max - min) / 2;
            if(valid(piles, mid, h)){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return min;
    }
    public boolean valid(int [] nums, int g, int h){
        int c = 0;
        for(int n :nums){
            c += n % g == 0 ? n / g : n / g + 1;
        }
        return c <= h;
    }
}
