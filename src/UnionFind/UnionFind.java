package UnionFind;

public class UnionFind {
    int [] parents;
    int [] ranks;
    public UnionFind(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i ++){
            parents[i] = i;
        }
    }
    public int find(int k){
        while(parents[k] != k){
            parents[k] = parents[parents[k]];
            k = parents[k];
        }
        return k;
    }
    public void union(int k1, int k2){
        int root1 = find(k1);
        int root2 = find(k2);
        if(root1 == root2){
            return;
        }
        else if(ranks[root1] < ranks[root2]){
            parents[root1] = root2;
        }
        else{
            parents[root2] = root1;
            if(ranks[root1] == ranks[root2]){
                ranks[root1] ++;
            }
        }
    }
}
