package SortCollection.quickSort;

import Helper.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

public class ThreeWayQuickSort {

    public void threeWaySort(int[] list, int l, int r) {
        if (l >= r)
            return;

        //partition
       // Random random = new Random();
       // swap(list, l, l + random.nextInt(r - l + 1));

        int lt = l;
        int gt = r+1;
        int i = l + 1;

        while ((i<gt)) {
            if (list[i] < list[l]) {
                swap(list, i, lt + 1);
                i++;
                lt++;
                if(i>r)   //有一种可能是当前元素本来就是当前范围中最大元素，gt一直停留在数组外，所以当i扫描完最后一个元素时，最后一个元素小于或者等于list[l]
                    break; //此时i=r+1,如果当前while循环仍然没有结束（即会用到list[i]）会使list[i]出现数组越界，所以要在后面需要使用list[i]的i++操作后进行判断
                //如果i > r，则结束当前while循环
            }
            if (list[i] > list[l]) {
                swap(list, i, gt-1);
                gt--;
            }


            if (list[i] == list[l]) {
                i++;
            }








        }

        swap(list, l, lt);

        //partition done
        //list[l ... lt-1] < list[lt]
        //list[lt ... gt-1] == list[lt]
        //list[gt ... r] > list[lt]
        threeWaySort(list, l, lt - 1);
        threeWaySort(list, gt, r);
    }

    public void sort(int[] list) {
        int n = list.length;
        threeWaySort(list, 0, n - 1);

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void SortTest(int n) {
        //n for the size of the list
        //the item varies from 0 to n.
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        System.out.println("The original list is:");
        System.out.println(Arrays.toString(list));

        System.out.printf("\n");
        double startTime = System.currentTimeMillis();
        sort(list);
        double endTime = System.currentTimeMillis();


        System.out.println("The ordered list is:");
        System.out.println(Arrays.toString(list));

        System.out.println("\nSortType: Three-way Quick Sort");
        System.out.println("Time:" + (endTime - startTime) / 1000 + " second");

    }

    public double getTime(int n, int min, int max) {
        // min&max describe the interval of the to-be-sorted items to specify different situations.
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, min, max);

        double startTime = System.currentTimeMillis();
        sort(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime) / 1000;

        System.out.println("Sort type:Three-way Quick Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: " + second + " second");
        return second;
    }

    public static void main(String[] args){
        int[] a = {1,1,1,1,1,1,1,1,1}
        ThreeWayQuickSort threeWayQuick = new ThreeWayQuickSort();
        threeWayQuick.SortTest(200);


    }
}