

public class Test {
    public static void main(String[] args){
        SortTestHelper helper = new SortTestHelper();
        int[] list = helper.RadnomTestList(100, 0, 100);
        int[] nearlyOrderedList = helper.NearlyOrderedList(100, 10);
        for(int i=0;i<nearlyOrderedList.length;i++)
              System.out.printf(" %d",nearlyOrderedList[i]);
    }
}
