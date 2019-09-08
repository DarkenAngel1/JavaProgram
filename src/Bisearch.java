public class Bisearch {
    public static int bisearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while (lo<=hi)
        {
            mid=(lo+hi)/2;
            if (array[mid]==a){
                return mid+1;
            }else if (array[mid]<a){
                lo=mid+1;
            }else {
                hi=mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int[] arr={1,6,4,8,3,2,4};
        System.out.println(arr.length);
        int result=bisearch(arr,3);
        System.out.println(result);
    }
}
