import SortCollection.*;


public class Test {
    public static void main(String[] args){

        int n = 100000;

        SelectionSort selection = new SelectionSort();
        selection.SortTest(n);
        InsertionSort insertion = new InsertionSort();
        insertion.SortTest(n);

    }
}
