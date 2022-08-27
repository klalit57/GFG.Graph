package GFG;

public class CycleDetectDirectGraph {
    static boolean CycleDetectDirectedRecursion(DirectedGraph dg,int s, boolean [] visited, boolean [] recStack  ){
        visited[s]=true;
        recStack[s]=true;  // track the elements in that particular traversal
        for(int x:dg.adj.get(s)){
            if(!visited[x] && CycleDetectDirectedRecursion(dg,x,visited,recStack)){
                return true;
            }
            else if(recStack[x]){  //if elememt is visited and present in stack, cycle is present
                return true;
            }
        }
        recStack[s]=false;   //if no cycle is detected,all elements of recstack assign false by recursively
                             // so next traverse can be track seperately
        return false;
    }

    static boolean DFSDirectedCycleDetect(DirectedGraph dg, int v){
        boolean [] visited= new boolean[v];
        boolean [] recStack= new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(CycleDetectDirectedRecursion(dg,i,visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        DirectedGraph dg= new DirectedGraph(6);
        dg.addEdge(0,1);
        dg.addEdge(1,2);
        dg.addEdge(2,3);
        dg.addEdge(3,4);
        dg.addEdge(4,5);
        dg.addEdge(5,2);
        dg.addEdge(5,3);

        System.out.println(DFSDirectedCycleDetect(dg,dg.v));
    }
}
