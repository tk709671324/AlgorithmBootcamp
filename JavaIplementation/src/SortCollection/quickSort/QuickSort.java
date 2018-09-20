package SortCollection.quickSort;

import Helper.SortTestHelper;

import java.util.Arrays;

public class QuickSort {



    private int _partition(int[] list, int l, int r){

        int compareValue = list[l];

        int j = l; // list[l+1,j] < compareValue & list[j+1,i) >= compareValue

        for(int i = l + 1; i <= r; i++){
            if(list[i] < compareValue)
                swap(list, ++j, i);
        }

        swap(list , l, j);

        return j;
    }

    private void quickSort(int[] list, int l, int r){
        if(l >= r )
            return;

        int p = _partition(list, l, r);
        quickSort(list, l,p-1);
        quickSort(list, p+1, r);
    }

    public void sort(int[] list){
        int n = list.length;
        quickSort(list, 0, n-1);
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // test

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

        System.out.println("\nSortType: Quick Sort");
        System.out.println("Time:" + (endTime - startTime)/1000 + " second");

    }

    public double getTime(int n){
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        double startTime = System.currentTimeMillis();
        sort(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime)/1000;

        System.out.println("Sort type: Quick Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + " second");
        return second;
    }
}
