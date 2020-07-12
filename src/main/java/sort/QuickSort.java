package sort;

/**
 * @className: QuickSort
 * @description: TODO
 * @author: zyd
 * @date: 2020/7/12 20:29
 * @version: 1.0
 */
public class QuickSort {

    public static void sort(int[] arr, int left, int right) {
        //以left下标为基准
        if (left > right)
            return;
        int v = arr[left];
        int i = left;
        int j = right;
        //从右向左开始遍历，找到小于left下标的数字
        //从左向右开始遍历，找到大于left下标的数字
        //将两个下标数字进行交换
        while (i < j) {
            while (arr[j] >= v && i < j) {
                j--;
            }
            while (arr[i] <= v && i < j) {
                i++;
            }
            if (i < j) {
                int iv = arr[i];
                arr[i] = arr[j];
                arr[j] = iv;
            }
        }
        //交换left下标和i下标的值
        arr[left] = arr[i];
        arr[i] = v;
        //递归重复上面步骤
        sort(arr, left, j-1);
        sort(arr, j+1, right);
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
