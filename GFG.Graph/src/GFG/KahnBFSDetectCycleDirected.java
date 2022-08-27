package GFG;

import java.util.LinkedList;
import java.util.Queue;

public class KahnBFSDetectCycleDirected {
    static boolean topologicalSorting(DirectedGraph dg){
        int [] degree= new int[dg.v];
        for(int i=0;i<dg.v;i++){
            for(int j:dg.adj.get(i)){
                degree[j]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<dg.v;i++){
            if(degree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while (!q.isEmpty()){
            int curr=q.poll();
            for(int x:dg.adj.get(curr)) {
                if (--degree[x] == 0) {
                    q.add(x);
                }
            }
            count++;
        }
        return (count!=dg.v);
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

        System.out.println(topologicalSorting(dg));

        DirectedGraph dg2= new DirectedGraph(5);
        dg2.addEdge(0,1);
        dg2.addEdge(4,1);
        dg2.addEdge(1,2);
        dg2.addEdge(2,3);
        dg2.addEdge(3,1);
        System.out.println(topologicalSorting(dg2));

    }
}
