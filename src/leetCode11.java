class solution11{
    public int maxArea(int[] height) {
        int i,j,area=0,maxArea=0,min=0;
        for(i=0;i<height.length;i++){
            for (j=i+1;j<height.length;j++){
                if (height[i]>height[j])
                    min=height[j];
                else min=height[i];
                //area=(j-i)*min;
                if (area>maxArea)
                    maxArea=area;
            }
        }
        return maxArea;
    }
}
public class leetCode11 {
    public static void main(String[] args){
        int[] height={1,8,6,2,5,4,8,3,7};
        System.out.println(height.length);
        solution11 s=new solution11();
        int result=s.maxArea(height);
        System.out.println(result);
    }
}
