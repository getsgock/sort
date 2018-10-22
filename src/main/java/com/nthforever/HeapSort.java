package com.nthforever;

/**
 * @author Nthforever
 * @date 2018/10/22
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{3,5,8,1,22,54,4,9,34,43,11,44};
        //        int[] a = new int[]{8,5,0,3,7,1,2};

        int[] ints = heapSort(a);
        for (int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
            System.out.print(",");
        }
    }

    /**
     * 堆排序
     * @param array
     * @return
     */
    private static int[] heapSort(int[] array){
        creatHeap(array);
        //将第一个元素和最后一个交换
        for (int i= array.length -1;i>0;i--){
            array[0] = array[0]^array[i];
            array[i] = array[i]^array[0];
            array[0] = array[0]^array[i];
            keepHeap(array,0,i);
        }
        return array;
    }

    /**
     * 创建堆，从第一个非叶子节点下向上构建
     * @param array
     */
    private static void creatHeap(int[] array){
        //第一个非叶子节点下标
        int first = (array.length - 2) / 2;
        for (int i = first;i>=0;i--){
            keepHeap(array,i,array.length);
        }
    }

    /**
     * 维护堆的性质（大堆）
     * @param array
     * @param parent 父节点下标
     * @param end 用于排序后收缩堆
     */
    private static void keepHeap(int[] array,int parent,int end){
        //        int length = array.length;
        int left = parent*2+1;
        int right = parent*2+2;
        if (left > end-1){
            return ;
        }
        if (right > end-1){
            return;
        }
        int max = array[parent];
        int leftv = array[left];
        int rightv = array[right];
        if (leftv > max && leftv > rightv){
            //swap
            array[parent] = array[parent]^array[left];
            array[left] = array[left]^array[parent];
            array[parent] = array[parent]^array[left];
            //
            keepHeap(array,left,end);
        }
        if (rightv > max && rightv > leftv){
            array[parent] = array[parent]^array[right];
            array[right] = array[right]^array[parent];
            array[parent] = array[parent]^array[right];
            ///
            keepHeap(array,right,end);
        }
    }
}
