class Art{
    Art(){
        System.out.println("Art Constructor");
    }
}
class Drawing extends Art{
    Drawing(){
        System.out.println("Drawing Constructor");
    }
}
public class Cartoon extends Drawing{
    public Cartoon(){System.out.println("Cartoon Constructor");}
    public static void main(String[] args){
        Cartoon x=new Cartoon();
    }
}
