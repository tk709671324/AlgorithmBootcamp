import Helper.SortTestHelper;
import SortCollection.*;
import SortCollection.quickSort.DualPivotQuickSort;
import SortCollection.quickSort.QuickSort;


public class Test {
    public static void main(String[] args){

        int n = 1000000;

        SelectionSort selection = new SelectionSort();
        selection.getTime(n);
        InsertionSort insertion = new InsertionSort();
        insertion.getTime(n);

        MergeSort merge = new MergeSort();
        merge.getTime(n);
        QuickSort quick = new QuickSort();
        quick.getTime(n, 0 ,n);
        QuickSort quick2 = new QuickSort();
        quick2.getTime(10000, 0, 5);
        DualPivotQuickSort dualQuick = new DualPivotQuickSort();
        dualQuick.getTime(1000000,0 ,10);


    }
}
