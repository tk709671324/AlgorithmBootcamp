import java.util.Random;

public class SortTestHelper {

    //To return a random int array
    public int[] RadnomTestList(int n, int min, int max){
        //n for size of the list
        //min&max describe the interval of those generated elements(integers)
        //the interval is closed

        Random random = new Random();
        int[] list = new int[n];
        for (int i = 0;i < n;i++)
            list[i] = min + random.nextInt(max-min+1);

        return list;
    }

    //return a nearly ordered list,from small to large.
    public int[] NearlyOrderedList(int n, int Swaptimes){

        //n for the size of the list
        //Swaptimes describes the degree of the 'ordered'
        Random random = new Random();
        int[] list = new int[n];
        for(int i = 0; i < n; i++)
            list[i] = i;
        for (int i = 0; i < Swaptimes; i++){

            int a = random.nextInt(n+1);
            int b = random.nextInt(n+1);
            int temp = list[a];
            list[a] = list[b];
            list[b] = temp;

        }

        return list;


    }


}
