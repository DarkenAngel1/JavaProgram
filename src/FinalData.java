import java.util.Random;

class value {
    int i;
    public value(int i){
        this.i=i;
    }
}
public class FinalData {
    private static Random rand=new Random(47);
    private String id;
    public FinalData(String id){this.id=id;}
    private final int valueOne=9;
    private static final int VALUE_TWO=99;
    public static final int VALUE_THREE=39;
    private final int i4=rand.nextInt(20);
    static final int INT_5=rand.nextInt(20);
    private value v1=new value(11);
    private final value v2=new value(22);
    private static final value VAL_3=new value(33);
    private final int[] a={1,2,3,4,5,6};
    public String toString(){
        return id+":"+i4
    }
}
