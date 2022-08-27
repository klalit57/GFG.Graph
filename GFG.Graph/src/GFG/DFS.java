package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean [] visited){  //gfg method-1
        visited[s]=true;
        System.out.print(s+" ");
        for(int x:adj.get(s)) {
            if (visited[x] == false) {
                DFSRec(adj,x,visited);
            }
        }
    }
    static void DFS(ArrayList<ArrayList<Integer>> adj, int v){
        int count=0;  // if island count
        boolean [] visited= new boolean[v];
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                DFSRec(adj,i,visited);
                System.out.println();
                count++;  // if island count
            }
        }
        System.out.println("No. of island for this graph is: "+count);  // if island count
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    static void printGraph(ArrayList<ArrayList<Integer>> adj){
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int v = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        printGraph(adj);

        DFS(adj,v);
    }
    }
