package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUnweightedGraph {

    public static void shortestPathAlgo(Graph g, int s, int [] dist){
        boolean [] visited= new boolean[g.v];
        Queue<Integer> q= new LinkedList<>();
        q.add(s);
        visited[s]=true;

        while(!q.isEmpty()){
            int curr= q.poll();
            for (int x:g.adj.get(curr)){
                if(visited[x]==false){
                    dist[x]=dist[curr]+1;  //distance assigned for cur
                    visited[x]=true;       //marked visited
                    q.add(x);              //added to queue for further traverse
                }
            }
        }
    }
    static void printArray(int [] arr){
        System.out.println("dist array:  ");
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String [] args){
        Graph g= new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.printGraph();

        int [] dist= new int[g.v];
        shortestPathAlgo(g,0,dist);
        printArray(dist);

    }
}
