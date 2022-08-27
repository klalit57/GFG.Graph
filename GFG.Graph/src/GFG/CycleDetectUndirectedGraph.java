package GFG;

public class CycleDetectUndirectedGraph {
    static  boolean DFScycleDetectionUndirected(Graph g, int s, boolean[] visited, int parent){
        visited[s]=true;
        for(int x:g.adj.get(s)){
            if(!visited[x]){
                if(DFScycleDetectionUndirected(g,x,visited,s)){
                    return true;
                }
            }else if(x!=parent){ //if element is visited and it is not it's parent cycle is present
                return true;
            }
        }
        return false;
    }

    static boolean DFSCycleDetect(Graph g, int v){
        boolean [] visited= new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(DFScycleDetectionUndirected(g,i,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] args){
        Graph g= new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,4);
        g.addEdge(4,5);
        g.addEdge(1,3);
        g.addEdge(2,3);


        System.out.println(DFSCycleDetect(g,g.v));

    }
}
