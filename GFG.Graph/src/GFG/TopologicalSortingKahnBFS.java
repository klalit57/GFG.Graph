package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortingKahnBFS {
    static void topologicalSorting(DirectedGraph dg){
        int [] degree= new int[dg.v];
        for(int i=0;i<dg.v;i++){
            for(int j:dg.adj.get(i)){
                degree[j]++;
            }
        }
        //printArray(degree);
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<dg.v;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int x:dg.adj.get(curr)) {
                if (--degree[x] == 0) {
                    q.add(x);
                }
            }
        }
    }

    static void printArray(int [] arr){
        System.out.println("degree array:  ");
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DirectedGraph dg= new DirectedGraph(6);
        dg.addEdge(0,1);
        dg.addEdge(0,2);
        dg.addEdge(1,3);
        dg.addEdge(2,3);
        dg.addEdge(3,4);
        dg.addEdge(3,5);

        topologicalSorting(dg);
    }
}
