package GFG;

import java.util.Stack;

public class TopologicalSortingDFS {
    static void DFSRecursive(DirectedGraph dg, int s, boolean [] visited, Stack<Integer> st){
        visited[s]=true;
        for(int i:dg.adj.get(s)){
            if(!visited[i]){
                DFSRecursive(dg,i,visited,st);
            }
        }
        st.push(s);
    }
    static void DFS(DirectedGraph dg){
        Stack<Integer> st= new Stack<>();
        boolean[] visited= new boolean[dg.v];
        for(int i=0;i<dg.v;i++){
                if(!visited[i]){
                    DFSRecursive(dg,i,visited,st);
                }
        }
        printStack(st);
    }
    static void printStack(Stack<Integer> st){
        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }

    public static void main(String[] args) {
        DirectedGraph dg= new DirectedGraph(6);
        dg.addEdge(0,1);
        dg.addEdge(0,2);
        dg.addEdge(1,3);
        dg.addEdge(2,3);
        dg.addEdge(3,4);
        dg.addEdge(3,5);

        DFS(dg);

        System.out.println();
        DirectedGraph dg2= new DirectedGraph(5);
        dg2.addEdge(0,1);
        dg2.addEdge(1,3);
        dg2.addEdge(3,4);
        dg2.addEdge(2,3);
        dg2.addEdge(2,4);

        DFS(dg2);

    }

}
