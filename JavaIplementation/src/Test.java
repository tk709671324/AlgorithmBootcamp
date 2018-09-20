import Helper.SortTestHelper;
import SortCollection.*;


public class Test {
    public static void main(String[] args){

        int n = 10000000;

      /*  SelectionSort selection = new SelectionSort();
        selection.getTime(n);
        InsertionSort insertion = new InsertionSort();
        insertion.getTime(n);
        */
        OptimizedMerge optimizedMerge = new OptimizedMerge();
        optimizedMerge.getTime(n);
        MergeSort mergeSort = new MergeSort();
        mergeSort.getTime(n);

    }
}
