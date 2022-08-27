package GFG;

import java.util.ArrayList;

public class Graph {
    int v;
    ArrayList<ArrayList<Integer>> adj;
    Graph(int v){
        this.v=v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0 ;i<v; i++) {
            adj.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    void printGraph() {
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

    }
}
