package GFG;

import java.util.*;

public class BFS {
    static void breadthFirstSearch1(ArrayList<ArrayList<Integer>> adj, int source){  //mycode
        System.out.print(source+" ");
        HashSet<Integer> h= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        h.add(source);
        q.add(source);
        while(!q.isEmpty()){
            int curr=q.poll();
            //the elements which are not in hashset are traversed,print, and added in hashset
            if(!h.contains(curr)){
                System.out.print(curr+" ");
                h.add(curr);
            }
            //elements which are in has set and queue both, thre neighbours who are not present in hashset are added in queue
            for(int i=0;i<adj.get(curr).size();i++) {
                if (h.contains(adj.get(curr).get(i)) == false){
                    q.add(adj.get(curr).get(i));
               }
            }
        }
        System.out.println();
    }

  static void breadthFirstSearch2(ArrayList<ArrayList<Integer>> adj,int v, int s){  //gfg with given source
        boolean [] visited= new boolean[v];  //to track items which are added once in queue
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while (!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");  //every popped element first printed, and then its neighbours who were not
                                         //visited are added in queue
            for(int x:adj.get(curr)){
                if(visited[x]==false){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
   }

    static void breadthFirstSearch3(ArrayList<ArrayList<Integer>> adj, int s, boolean [] visited){  //non connected graph method 3
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while (!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+" ");
            for(int x:adj.get(curr)){
                if(visited[x]==false){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }
    }
    static void disconnectedBFS(ArrayList<ArrayList<Integer>> adj, int v){  //method 3
        int count=0;
        boolean [] visited= new boolean[v];
        for(int i=0;i<v;i++){
            if(visited[i]==false){

                breadthFirstSearch3(adj,i,visited);
                System.out.println();
                count++;
            }
        }
        System.out.println("No. of island for this graph is: "+count);
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
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int v=6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0 ;i<v; i++) {
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,5);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,2,4);
        addEdge(adj,3,5);
        addEdge(adj,4,5);
        printGraph(adj);

        System.out.println("Enter source for BFS travel");
        int source=sc.nextInt();

        breadthFirstSearch1(adj,source);
        System.out.println();
        breadthFirstSearch2(adj,v,source);
        System.out.println();

        int v1=7;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<ArrayList<Integer>>(v1);
        for (int i = 0 ;i<v1; i++) {
            adj1.add(new ArrayList<Integer>());
        }
        addEdge(adj1,0,1);
        addEdge(adj1,0,2);
        addEdge(adj1,1,3);
        addEdge(adj1,2,3);
        addEdge(adj1,4,5);
        addEdge(adj1,4,6);
        addEdge(adj1,5,6);

        disconnectedBFS(adj1,v1);

    }
}
