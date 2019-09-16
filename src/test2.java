public class test2 {
    public static void main(String[] args){
        int []ins={2,3,5,1,23,6,78,34};
        int []ins2=sort(ins);
        for (int in:ins2){
            System.out.println(in);
        }
    }

    public static int[] sort(int[] ins){
        for(int i=0; i<ins.length-1; i++){//控制选择的次数
            int min_index = i;
            for(int j=i+1; j<ins.length-1; j++){
                if(ins[j]<ins[i]){
                    min_index = j;
                }
            }
            if(min_index != i){
                int temp = ins[i];
                ins[i] = ins[min_index];
                ins[min_index] = temp;
            }
        }
        return ins;
}
}