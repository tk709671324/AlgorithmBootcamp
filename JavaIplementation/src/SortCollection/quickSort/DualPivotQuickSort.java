package SortCollection.quickSort;

import Helper.SortTestHelper;

import java.util.Arrays;
import java.util.Random;

public class DualPivotQuickSort {

    private int _dualPivotPartition(int[] list, int l,int r){

        Random random = new Random();
        swap(list, l, l + random.nextInt(r-l+1));

        int compareValue = list[l];
        int i = l+1;
        int j = r;

        while(true){
            while((i <= r)&&(list[i] < compareValue))
                i++;
            while((j >= l+1)&&(list[j] > compareValue))
                j--;
            //when the 2 while loops stops, list[i](list[]j) should be no smaller(larger) than compareValue
            if (i > j)
                break;

            swap(list, i, j);
            i++;
            j--;
        }

        //in the final situation
        //from 0 to i-1 should be not larger than compareValue, list[i] >= compareValue
        //from j+1 to r should be not smaller than compareValure, list[j] <=compareValue
        // j is the position list[l] should be
        swap(list, l, j);

        return j;


    }

    private void dualPivotQuickSort(int[] list,int l, int r){
        if (l >= r)
            return;

        int pos = _dualPivotPartition(list, l, r);
        dualPivotQuickSort(list, l, pos);
        dualPivotQuickSort(list, pos+1, r);
    }

    public void sort(int[] list){
        int n = list.length;
        dualPivotQuickSort(list, 0, n-1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void SortTest(int n){
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

        System.out.println("\nSortType: Dual Pivot Quick Sort");
        System.out.println("Time:" + (endTime - startTime)/1000 + " second");

    }

    public double getTime(int n, int min, int max){
        // min&max describe the interval of the to-be-sorted items to specify different situations.
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, min, max);

        double startTime = System.currentTimeMillis();
        sort(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime)/1000;

        System.out.println("Sort type: Dual Pivot Quick Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + " second");
        return second;
    }





}
