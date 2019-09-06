package com.dmall.coder.datastruct;

import java.util.Arrays;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2019-08-15 8:39
 */
public class QuickSort {

    /**
     * 返回的是下次的high的下标
     *
     * @param s
     * @param low
     * @param high
     * @return
     */
    public static int quickAdjust(int s[], int low, int high) {
        int i = low;
        int j = high;
        int x = s[low];//基准元素
        while (i < j) {
            while (i < j && s[j] >= x) {
                j--;
            }
            if (i < j) {
                s[i] = s[j];
                i++;
            }
            while (i < j && s[i] < x) {
                i++;
            }
            if (i < j) {
                s[j] = s[i];
                j--;
            }
        }
        s[i] = x;
        return i;
    }

    public static void quickSort(int s[], int low, int high) {
        if(low <high){
            int i = quickAdjust(s, low, high);
            quickSort(s, low, i - 1);
            quickSort(s, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] s={78,2,68,5,89,34,21};
        quickSort(s,0,s.length-1);
        System.out.println(Arrays.toString(s));

        int[] s1={78,2,68,5,89,34,21};
        quick_sort(s1,0,s1.length-1);
        System.out.println(Arrays.toString(s1));
    }

    //快速排序
    public static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
}