import java.util.Scanner;

class VertexWG{
    String verName;
    int weight;
    double key;
    VertexWG parent;
    VertexWG nextNode;
}
class GraphWG{
    VertexWG[] vertexArray=new VertexWG[100];
    int verNum=0;
    int edgeNum=0;
}
class CreateWG{
    double infinity=10.0/0.0;
    public static VertexWG getVertex(GraphWG graph,String str){
        for (int i=0;i<graph.verNum;i++){
            if(graph.vertexArray[i].verName.equals(str)){
                return graph.vertexArray[i];
            }
        }
        return null;
    }
    public void initialWg(GraphWG graph){
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顶点数和边数：");
        graph.verNum=scan.nextInt();
        graph.edgeNum=scan.nextInt();
        System.out.println("请依次输入定点名称");
        for(int i=0;i<graph.verNum;i++){
            VertexWG vertex=new VertexWG();
            String name=scan.next();

        }
    }
}
public class Prim {
}
