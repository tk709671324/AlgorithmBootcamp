package SortCollection;

import Helper.SortTestHelper;

public class InsertionSort {
    //Insertion Sort implementation
    public void Insertion(int[] list){
        //list for the to-be-ordered list

        for (int i = 1;i < list.length;i++){
            int temp = list[i];
            int j = i - 1;
            while (j > -1 && list[j] > temp){
                list[j+1] = list[j];
                j -= 1;
            }
            list[j+1] = temp;
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
        Insertion(list);
        double endTime = System.currentTimeMillis();


        System.out.println("The ordered list is:");
        for (int i = 0;i < list.length; i++){
            System.out.printf("%d ",list[i]);
        }

        System.out.println("\nSortType: Insertion Sort.");
        System.out.println("Time:" + (endTime - startTime)/1000 + " second");

    }
    public double getTime(int n){
        //get the time for sorting an array of length n
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(n, 0, n);

        double startTime = System.currentTimeMillis();
        Insertion(list);
        double endTime = System.currentTimeMillis();
        double second = (endTime - startTime)/1000;

        System.out.println("Sort type: Insertion Sort");
        System.out.println("Size:" + n);
        System.out.println("Time: "+ second + "second");
        return second;
    }
}
