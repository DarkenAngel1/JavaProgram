import java.util.Scanner;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr=s.toCharArray();
        int maxlen=0;
        int leftindex=0;
        for (int i=0;i<arr.length;i++)
        {
            for(int j=leftindex;j<i;j++){
            if (arr[i]==arr[j]){
                maxlen=Math.max(maxlen,i-leftindex);
                leftindex=j+1;
                break;
            }
        }}
        return maxlen;
    }
}
public class LeetCode3 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        Solution ss=new Solution();
        int maxlen=ss.lengthOfLongestSubstring(s);
        System.out.println(maxlen);
    }
}
