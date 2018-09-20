package SortCollection;


import java.util.Arrays;

public class MergeSortBU  {
    public void mergeSortBU(int[] list){
        int n = list.length;

        for (int size = 1; size < n ; size *=2){
            for (int i = 0; i + size < n ; i += size*2 ){
                int min = i+size+size-1 <= n-1? i+size+size-1:n-1;
                _Merge(list, i, i+size-1, min);
            }
        }

    }
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


    public static void main(String[] args){
        int[] a = {2,3,5,34,345,2,4,5,6,3,234,13,14,555,453,2,43,2,3,5,66,7,84576,34,56,3345,45,34,4};
        MergeSortBU mergeSortBU = new MergeSortBU();
        mergeSortBU.mergeSortBU(a);
        System.out.println(Arrays.toString(a));

    }
}
