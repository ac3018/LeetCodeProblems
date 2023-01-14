import java.util.Arrays;

public class NumberOfConnectedComponentsInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        int res = n;
        // par[i] is the parent of node i
        int[] par = new int[n];
        // rank[i] is the rank of the set node i is in
        int[] rank = new int[n];
        // initialize par[] to [0,..., n - 1]
        for(int i = 0; i < n; i++) par[i] = i;
        // initialize rank[] to [1, 1,..., 1]
        Arrays.fill(rank, 1);

        for(int[] edge : edges) {
            // If a node is able to be added to another set, subtract one from res
            if(union(edge[0], edge[1], par, rank)) res--;
        }
        return res;
    }

    // Find the parent of node x
    public int find(int x, int[] par) {
        int parent = par[x];
        while(par[parent] != parent) {
            // path compression
            par[parent] = par[par[parent]];
            parent = par[parent];
        }
        return parent;
    }

    public boolean union(int x, int y, int[] par, int[] rank) {
        int p1 = find(x, par);
        int p2 = find(y, par);
        if(p1 == p2) return false;

        // Union by rank
        if(rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
class Solution {
    public static void main(String[] args) {
        NumberOfConnectedComponentsInUndirectedGraph sol = new NumberOfConnectedComponentsInUndirectedGraph();

        // n = 5, edges = [[0, 1], [1, 2], [3, 4]]
        System.out.println(sol.countComponents(5, new int[][] {{0, 1}, {1, 2}, {3, 4}}));
    }
}
