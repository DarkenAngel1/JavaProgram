package access;

import access.dessert.*;

public class ChocolateChip extends Cookie {
    ChocolateChip(){
        System.out.println("ChocolateChip construction");
    }
    public void chomp(){
        bite();
    }
    public static void main(String[] args){
        ChocolateChip x=new ChocolateChip();
        x.chomp();
    }
}
