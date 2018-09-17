package SortCollection;

import Helper.SortTestHelper;

import java.util.Arrays;

public class MergeSort {
    //The entrance of the merge sort function
    public void Merge(int[] list){
        _Mergesort(list, 0, list.length -1);
    }
    //merge function : merge sort the specific interval.
    private void _Mergesort(int[] list, int l, int r){
        //list : list to be ordered
        //l : the left border of the to-be-ordered interval.
        //r : the right border of the to-be-ordered interval.
        if (l >= r)
            return;


        int mid = (l + r) / 2;
        _Mergesort(list, l, mid);
        _Mergesort(list, mid+1, r);
        _Merge(list, l, mid, r);

    }

    //merge two part in a list into an ordered one .
    private void _Merge(int[] list, int l, int mid, int r){
       
        int [] assist =  Arrays.copyOfRange(list, l, r+1);
        int k = l;
        int i = l;
        int j = mid + 1;

        for (;k <= r; k++){
            if(i > mid){
                list[k] = assist[j-l];
                j++;
            }
            else if(j > r){
                list[k] = assist[i-l];
                i++;
            }
            else {
                if (assist[i-l] <= assist[j-l]){
                    list[k] = assist[i-l];
                    i++;
                }
                else{
                    list[k] = assist[j-l];
                    j++;
                }
            }

        }

    }

    public static void main(String[] args){
        int [] a = {6,1,2,2,4,6,8,33,1,43};
        MergeSort mergeSort = new MergeSort();
        mergeSort.Merge(a);
        System.out.println(Arrays.toString(a));
    }

    public void SortTest(int n){
        //n for the size of the list
        //the item varies from 0 to n.
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        System.out.println("The original list is:");
        for (int i =0;i < list.length;i++){
            System.out.printf(" %d",list[i]);
        }
        System.out.printf("\n");
        double startTime = System.currentTimeMillis();
        Merge(list);
        double endTime = System.currentTimeMillis();


        System.out.println("The ordered list is:");
        for (int i = 0;i < list.length; i++){
            System.out.printf(" %d",list[i]);
        }

        System.out.println("\nSortType: Merge Sort");
        System.out.println("Time:" + (endTime - startTime)/1000 + " second");

    }

    public double getTime(int n){
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        double startTime = System.currentTimeMillis();
        Merge(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime)/1000;

        System.out.println("Sort type: Merge Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + "second");
        return second;
    }

}
