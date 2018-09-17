package SortCollection;

import Helper.SortTestHelper;

public class SelectionSort {
    //Selection Sort implementation
    public void Selection(int[] list){
        //implemtent a selection sort algorithm, from small to large
        //return the ordered array
        for (int i = 0; i < list.length; i++){
            int min = i;
            for (int j = i+1; j < list.length; j++)
                if (list[j] < list[min])
                        min = j;
            if (i!=min){
                int temp = list[i];
                list[i] = list[min];
                list[min] = temp;
            }


        }
    }

    // Test the time complexity
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
        Selection(list);
        double endTime = System.currentTimeMillis();


        System.out.println("The ordered list is:");
        for (int i = 0;i < list.length; i++){
            System.out.printf(" %d",list[i]);
        }

        System.out.println("\nSortType: Selection Sort");
        System.out.println("Time:" + (endTime - startTime)/1000 + " second");

    }

    public double getTime(int n){
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        double startTime = System.currentTimeMillis();
        Selection(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime)/1000;

        System.out.println("Sort type: Selection Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + "second");
        return second;
    }
}
