import java.util.Scanner;
public class KmpStringMatch {
    public static int kmpStringMatch(String source,String pattern){
        int i=0;
        int j=0;
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int slen=s.length;
        int plen=p.length;
        int []next=getNext(p);
        while(i<slen&&j<plen){
            if (j==-1||s[i]==s[j])
            {
                ++i;
                ++j;
            }
            else{
                j=next[j];
            }
        }
        if(j == plen)
            return i - j;
        else
            return -1;
    }
    private static int[] getNext(char []p){
        int plen=p.length;
        int []next=new int[plen];
        int k=-1;
        int j=0;
        next[0]=-1;
        while (j<plen-1){
            if (k==-1||p[j]==p[k])
            {
                ++k;
                ++j;
                next[j]=k;
            }
            else{
                k=next[k];
            }
        }
        System.out.println("next函数值：");
        for(int ii = 0;ii<next.length;ii++)
        {

            System.out.print(next[ii]+ " ");
        }
        System.out.println();
        return next;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(kmpStringMatch(a, b));
    }
}
