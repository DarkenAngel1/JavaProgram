public class NQueeens {
    int []x;
    int N;
    int sum=0;
    public int totalNQueens(int n){
        N=n;
        x=new int [N+1];
        backTrace(1);
        return sum;
    }
    private boolean place(int col){
        for (int i=1;i<col;i++){
            if(Math.abs(col-i)==Math.abs(x[col]-x[i])||x[col]==x[i]){
                return false;
            }
        }
        return true;
    }
    private void backTrace(int t){
        if (t>N){
            sum++;
        }else{
            for (int j=1;j<=N;j++){
                x[t]=j;
                if (place(t)){
                    backTrace(t+1);
                }
            }
        }
    }
    public static void main(String[] args){
        NQueeens n=new NQueeens();
        System.out.println(n.totalNQueens(8));
    }
}
