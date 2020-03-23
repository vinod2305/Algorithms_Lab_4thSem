import java.util.*;
class node
{
    int vertex;
    node link;
}
public class bipartite
{
        static int visited[]=new int[20];
        static Queue<Integer> queue= new LinkedList<>();
        static node g[]=new node[20];
        static int n;
        static int color[]=new int[20];
        static Scanner in=new Scanner(System.in);
        static void insert(int vi,int vj)
        {
                node temp,trav;
                temp=new node();
                temp.vertex=vj;
                temp.link=null;
                if(g[vi]==null)
                {
                        g[vi]=temp;
                }
                else
                {
                        for(trav=g[vi];trav.link!=null;trav=trav.link);
                        trav.link=temp;
                }
        }
        static void creategraph()
        {
                int i,vi,vj,n;
                System.out.println(" Enter number of vertices: ");
                n=in.nextInt();
                for(i=0;i<n;i++)
                {
                        g[i]=null;
                }
                System.out.println(" Enter Number of edges: ");
                n=in.nextInt();
                for(i=0;i<n;i++)
                {
                        System.out.println(" Enter an edge(a,b): ");
                        vi=in.nextInt();
                        vj=in.nextInt();
                        insert(vi,vj);
                }
        }
        static boolean isBipartite(int v)
        {
                node t;
                System.out.println("Source vertex: "+String.valueOf(v)+"\t");
                System.out.println("Nodes visited in BFS order are: ");
                visited[v]=1;
                queue.add(v);
                if(color[v]==-1){
                    color[v]=0;
                }
                while(!queue.isEmpty()){
                    v=queue.remove();
                    for(t=g[v];t!=null;t=t.link)
                    {
                        if(color[t.vertex]==-1){
                            if(color[v]==0){
                                color[t.vertex]=1;
                            }
                            else if(color[v]==1){
                                color[t.vertex]=0;
                            }
                            System.out.println("("+v+","+t.vertex+")");
                            queue.add(t.vertex);
                            visited[t.vertex]=1;
                        }
                        else if(color[t.vertex] == color[v]){
                            return false;
                        }                            
                    }
                }
                return true;
        }
        public static void main(String args[])
        {
                int i;
                for(i=0;i<20;i++)
                {
                        visited[i]=0;
                        color[i]=-1;
                }
                creategraph();
                System.out.println("Enter source vertex: ");
                int source=in.nextInt();
                boolean result = isBipartite(source);
                System.out.println("Graph is Bipartite: " + result);
                System.out.println();
                if(result){
                    int j = 1;
                    while(color[j]!=-1){
                        if(color[j]==0){
                            System.out.println(j+": RED");
                        }
                        else if(color[j]==1){
                            System.out.println(j+": BLUE");
                        }
                        j++;
                    }
                }
                System.out.println();
        }

}