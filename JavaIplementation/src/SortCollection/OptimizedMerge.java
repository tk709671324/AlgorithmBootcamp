package SortCollection;

import Helper.SortTestHelper;

import java.util.Arrays;

public class OptimizedMerge {
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
        if (r-l < 9) {
            partialInsertion(list, l, r);   // when list size come to a small number. Insertion sort has a better performance
            return;
        }

        int mid = (l + r) / 2;
        _Mergesort(list, l, mid);
        _Mergesort(list, mid+1, r);
        if(list[mid] >= list[mid+1])      // if list[mid] < list[mid+1] , it means the aim list is already ordered
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

        System.out.println("\nSortType: Optimized Merge Sort");
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

        System.out.println("Sort type: Optimized Merge Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + " second");
        return second;
    }

    public void partialInsertion(int[] list, int l, int r){

        for (int i = l+1; i <= r;i++){
            int temp = list[i];
            int j = i-1;
            for(; j >= l; j--){
                if (temp < list[j])
                    list[j+1] = list[j];
                else
                    break;
            }
            list[j+1] = temp;


        }

    }

}
