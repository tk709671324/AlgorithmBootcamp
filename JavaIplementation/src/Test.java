import Helper.SortTestHelper;
import SortCollection.*;
import SortCollection.quickSort.QuickSort;


public class Test {
    public static void main(String[] args){

        int n = 10000000;

      /*  SelectionSort selection = new SelectionSort();
        selection.getTime(n);
        InsertionSort insertion = new InsertionSort();
        insertion.getTime(n);
        */
        MergeSort merge = new MergeSort();
        merge.getTime(n);
        QuickSort quick = new QuickSort();
        quick.getTime(n);

    }
}
