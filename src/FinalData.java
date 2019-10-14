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
    //Can be compile-time constants
    private final int valueOne=9;
    private static final int VALUE_TWO=99;
    //Typical public constant
    public static final int VALUE_THREE=39;
    //Cannot be compile-time constants
    private final int i4=rand.nextInt(20);
    static final int INT_5=rand.nextInt(20);
    private value v1=new value(11);
    private final value v2=new value(22);
    private static final value VAL_3=new value(33);
    private final int[] a={1,2,3,4,5,6};
    public String toString(){
        return id+": "+"i4 = "+i4+", INT_5= "+INT_5;
    }
    public static void main(String[] args){
        FinalData fd1=new FinalData("fd1");
        //!fd1.valueOne++;   //Error:can't change value
        fd1.v2.i++;
        fd1.v1=new value(9);
        for(int i=0;i<fd1.a.length;i++){
            fd1.a[i]++;
            //fd1.v2=new value(0);  //Error:Can't change reference
            //fd1.VAL_3=new value(1);
            //fd1.a=new int[3];
            System.out.println(fd1);
            System.out.println("Creating new FinalData");
            FinalData fd2=new FinalData("fd2");
            System.out.println(fd1);
            System.out.println(fd2);
        }
    }
}
