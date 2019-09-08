public class test1{
    public static void main(String[] args){
        int []arr={6,3,8,2,9,1};
        sort(arr);
        for(int i:arr){
            System.out.println(i+" ");
        }
    }
    public static void sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
