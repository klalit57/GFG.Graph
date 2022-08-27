package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Pair{
    int v;
    int w;
    Pair (int v, int w){
        this.v=v;
        this.w=w;
    }
}
class WeightedGraph{
    int v;
    ArrayList<ArrayList<Pair>> adj;
    WeightedGraph(int v){
        this.v=v;
        adj = new ArrayList<ArrayList<Pair>>(v);
        for (int i = 0 ;i<v; i++) {
            adj.add(new ArrayList<Pair>());
        }
    }
    void addEdge(int u, int v, int w) {
        adj.get(u).add( new Pair(v,w));
    }
}

public class ShortestPathDAG {

    public static void shortPath(int [] shortDistance, Stack<Integer> st, WeightedGraph wg){
        boolean flag=true;
        while(!st.isEmpty()){
            int prev= st.pop();
            if(flag) {
                shortDistance[prev] = 0;
                flag=false;
            }
            for(Pair pair:wg.adj.get(prev)){
                    shortDistance[pair.v]= Math.min(shortDistance[pair.v],shortDistance[prev]+pair.w);
                }
        }
    }
    public static void DFSRecursive(int s, WeightedGraph wg,boolean [] visited,Stack<Integer> st ){
        visited[s]=true;
        for(Pair pair:wg.adj.get(s)){
            if(!visited[pair.v]){
                DFSRecursive(pair.v,wg,visited,st);
            }
        }
        st.add(s);
    }

    public static void topologicalSortingDFS(WeightedGraph wg){
        Stack<Integer> st= new Stack<>();
        boolean[] visited= new boolean[wg.v];

        for(int i=0;i<wg.v;i++){
            if(!visited[i]){
                DFSRecursive(i,wg,visited,st);
            }
        }
        int [] shortDistance= new int[wg.v];
        for(int i=0;i<shortDistance.length;i++){
            shortDistance[i]=Integer.MAX_VALUE;
        }
        shortPath(shortDistance,st,wg);
        printDistance(shortDistance);
    }

    static void printDistance(int [] shortDistance){
        for(int i=0;i<shortDistance.length;i++){
            System.out.print(shortDistance[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        WeightedGraph wg= new WeightedGraph(6);
        wg.addEdge(0,1,2);
        wg.addEdge(0,4,1);
        wg.addEdge(1,2,3);
        wg.addEdge(4,2,2);
        wg.addEdge(4,5,4);
        wg.addEdge(2,3,6);
        wg.addEdge(5,3,1);

        topologicalSortingDFS(wg);

    }
}
