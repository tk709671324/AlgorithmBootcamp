import SortCollection.*;


public class Test {
    public static void main(String[] args){

        int n = 100000;

      /*  SelectionSort selection = new SelectionSort();
        selection.getTime(n);
        InsertionSort insertion = new InsertionSort();
        insertion.getTime(n);
        */
        MergeSort merge = new MergeSort();
        merge.SortTest(n);

    }
}
