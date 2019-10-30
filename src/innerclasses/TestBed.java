package innerclasses;

public class TestBed {
    public void f(){System.out.println("f()");}
    public static class Test{
        public static void main(String[] args){
            TestBed t=new TestBed();
            t.f();
        }
    }
}
