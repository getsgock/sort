package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/22
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,5,8,1,22,54,4,9,34,43,11,44};

        int[] ints = shellSort(a);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }

    /**
     * 插入排序
     * 类似书上摸扑克牌
     * @param array
     * @return
     */
    private static int[] insertSort(int[] array){
        if (array.length <2)
            return array;
        for (int i = 1;i<array.length;i++){
            //取出一张牌
            int card = array[i];
            //和前面的所有牌比较
            for (int j =i;j>0;j--){
                if (array[j]<array[j-1]){
                    //交换前后两个的值
                    array[j]= array[j]+array[j-1];
                    array[j-1]=array[j] - array[j-1];
                    array[j] = array[j] - array[j-1];
                }else {
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 希尔排序
     * @param array
     * @return
     */
    private static int[] shellSort(int[] array){
        int len = array.length;
        //分组 组距为step
        for (int step = len /2;step >= 1; step/=2){
            //分别对每个组距进行插入排序
            for (int i =0;i<step;i++){
                //当组距为i时，对每组进行排序
                for (int j = i+step;j<len;j+=step){
                    if (array[j-step] > array[j]){
                        int key = array[j];
                        int m = j;
                        while (m>=step&&array[m-step] > key){
                            array[m] = array[m-step];
                            m-=step;
                        }
                        array[m] = key;
                    }
                }

            }
        }
        return array;
    }
}
