class poppet{
    private int i;
    poppet(int ii){
        i=ii;
    }
}
public class BlankFInal {
    private final int i=0;
    private final int j;
    private final poppet p;
    public BlankFInal(){
        j=1;
        p=new poppet(1);
    }
    public BlankFInal(int x){
        j=x;
        p=new poppet(x);
    }
    public static void main(String[] args){
        new BlankFInal();
        new BlankFInal(47);
    }
}
