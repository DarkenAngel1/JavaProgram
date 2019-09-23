import java.util.Scanner;

public class bruteForceStringMatch {
    public static int bruteForceStringMatch(String source,String pattern){
        int slen=source.length();
        int plen=pattern.length();
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();
        int i=0;int j=0;
        if (slen<plen){
            return -1;
        }
        else
        {
            while(i<slen&&j<plen)
            {
                if (s[i]==p[j])
                {
                    i++;
                    j++;
                }
                else{
                    i=i-(j-1);
                    j=0;
                }
            }
            if (j==plen){
                System.out.println("匹配成功");
                return i-j;
            }else{
                return -1;
            }

        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String a=input.nextLine();
        String b=input.nextLine();
        bruteForceStringMatch(a,b);
    }
}
