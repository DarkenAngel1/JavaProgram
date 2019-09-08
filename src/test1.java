import java.util.Arrays;

public class test1 {
    /**
     * 如何把一个整型数组中，奇数偶数进行分离。如前面放奇数，后面放偶数
     *
     * 前提条件：不引入新的数组,一次for循环
     *
     * 基本思想：一次循环，一个指针往前走，一个指针往后走
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int count = 0;
        int last_index = arrays.length - 1;

        System.out.println("数组长度: " + arrays.length);
        // for中的结束条件是，前面下标位置大于后面小标位置，相当于一个从前面开始走，一个从后面开始走，中间位置相遇就不走了
        for (int first_index = 0; first_index < last_index; first_index++) {
            count++;
            System.out.println(" first_index: " + first_index + " - last_index: " + last_index);

            int last = arrays[last_index];
            int first = arrays[first_index];
            // 情况1：如果前面是偶数，后面是奇数，则交换位置
            if (first % 2 == 0 && last % 2 != 0) {
                arrays[last_index] = first;
                arrays[first_index] = last;
                last_index--;// 此处注意后面的下标位置往前移，而前面的下标位置会在for循环中first_index++往后移动
            } else if (first % 2 == 0 && last % 2 == 0) {
                // 情况2：只有一种情况，前面偶数，后面也是偶数，需要前面下标不变，而后面需要往前移动
                last_index--;
                first_index--;
            } else if (first % 2 != 0 && last % 2 == 0) {
                // 情况3：前面是奇数 后面是偶数，这已经是我们需要的,后面下标往前面走，前面下标在for循环中往后移动
                last_index--;
            } else {
                // 情况4：前面是奇数，后面也是奇数,后面不做任何操作，前面下标位置在for中会往后移动
                // 什么也不需要干，因为后面的位置本来就不会在for中移动
            }
        }
        System.out.println("总共循环次数：" + count);
        System.out.println(Arrays.toString(arrays));
    }
}

