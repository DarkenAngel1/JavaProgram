import java.util.Iterator;
import java.util.Scanner;

class Graph{
    private final int V;//顶点数目
    private int E;//边的数目
    private Bag<Integer>[] adj;//邻接表

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];//创建邻接表
        for(int v = 0;v<V;v++){
            adj[v] = new Bag<Integer>();
        }
    }
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){ return adj[v];}
    public String toString(){
        String s = V + " vertices, " + E +" edges\n";
        for(int v=0;v<V;v++){
            s+=v+":";
            for(int w:this.adj(v))
                s+=w+" ";
            s+="\n";
        }
        return s;
    }
}
class Bag<Item> implements Iterable<Item> {
    //链表实现Bag
    private Node first;//链表首结点
    private class Node{
        Item item;
        Node next;
    }
    //和stack的push方法完全相同，在头部添加
    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
public class GraphMaterix{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph G = new Graph(4);//此处传入顶点数
        for(int i=0;i<6;i++){//此处传入边数 ，这里假设有六条边
            int a = in.nextInt();
            int b= in.nextInt();
            G.addEdge(a,b);
        }
        System.out.println(G.toString());
    }
}