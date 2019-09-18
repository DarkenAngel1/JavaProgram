public class Dijkstra {
    public static final int MAX = Integer.MAX_VALUE;
    public static int[] dijkstra(int [][]weight,int start){
        int length=weight.length;   //获取顶点个数
        int []shortpath=new int[length];
        shortpath[0]=0;
        String []path=new String[length];
        for (int i=0;i<length;i++){
            path[i]=start+"->"+i;
        }
        int []visited=new int[length];
        for (int i=0;i<length;i++){
            visited[i]=0;
        }
        visited[0]=1;
        for (int m=1;m<length;m++){
            int k=-1;
            int dmin=Integer.MAX_VALUE;
            for (int n=0;n<length;n++){
                if(visited[n]==0&&weight[start][n]<dmin){
                    dmin=weight[start][n];
                    k=n;
                }
            }
            shortpath[k]=dmin;
            visited[k]=-1;
            for (int j=0;j<length;j++){
                if (visited[j]==0&&weight[k][j]!=Integer.MAX_VALUE&&weight[start][k]+weight[k][j]<weight[start][j]){
                    weight[start][j]= weight[start][k] + weight[k][j];
                    path[j]=path[k]+"->"+j;
                }
            }
        }
        for(int i=1;i<length;i++){
            System.out.println("起始点到" + i + "的最短路径为:" + path[i] + "距离为：" + shortpath[i]);
        }
        return shortpath;
    }
    public static void main(String[] args){
        int[][] weight={{0,50,70,MAX,MAX},
                {50,0,15,30,MAX},
                {70,15,0,MAX,40},
                {MAX,30,MAX,0,20},
                {MAX,MAX,40,20,0}};
        dijkstra(weight,0);
    }
}
