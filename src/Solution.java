import java.util.Stack;

class Pair{
    String s;
    int n;
    public Pair(String s, int n) {
        this.s = s;
        this.n = n;
    }
}
class Solution {
    public String decodeString(String s) {
        int p = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        String ans = "";
        while(p < s.length()){
            while(s.charAt(p)  - '0' < 10 && s.charAt(p) - '0' > -1){
                i = i * 10 + (s.charAt(p) - '0');
                p ++;
            }
            if(s.charAt(p) == '[') p ++;
            while(p < s.length() && s.charAt(p) - 'a' < 27 && s.charAt(p) - 'a' > -1){
                sb.append(s.charAt(p));
                p ++;
            }
            if(p < s.length() && s.charAt(p) == ']'){
                StringBuilder t = new StringBuilder();
                if(sb.length() > 0) {
                    for (int x = 0; x < i; x++) {
                        t.append(sb.toString());
                    }
                }
                else{
                    Pair pa = stack.pop();
                    for (int x = 0; x < pa.n; x++) {
                        t.append(pa.s);
                    }
                }
                if (stack.empty()) {
                    ans += t.toString();
                } else {
                    stack.peek().s += t;
                }
                p++;
            }
            else{
                if(i > 0)stack.add(new Pair(sb.toString(),i));
                else ans += sb.toString();
            }
            sb = new StringBuilder();
            i = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

    }
}