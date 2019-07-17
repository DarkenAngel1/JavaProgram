package access;

class Sundae{
    private Sundae(){}
    static Sundae makeASundae(){
        return new Sundae();
    }
    void ptftest(){
        System.out.println("AMD YES!");
    }
}
public class IceCream {
    public static void main(String[] args){
        //Sundae x=new Sundae();
        Sundae x=Sundae.makeASundae();
        x.ptftest();
    }
}
