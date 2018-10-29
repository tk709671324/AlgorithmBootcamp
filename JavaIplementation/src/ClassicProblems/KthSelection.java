package ClassicProblems;

import java.util.Random;

public class KthSelection {

	private static int partition(Comparable[] arr, int l, int r){



		int j = l;

		Comparable v = arr[l];

		for (int i = l + 1; i < r; i++){
			if(arr[i].compareTo(v) < 0){
				j++;
				swap(arr,i,j);
			}
		}
		swap(arr, j, l);

		return j;

	}

	private static Comparable solve(Comparable[] arr, int l, int r, int k){
		if(l == r){
			return arr[l];
		}
		int p = partition(arr, l, r);
		if(p == k){
			return arr[p];
		}
		if(p > k){
			return solve(arr, l, p - 1, k);
		}
		else {
			return solve(arr, p + 1, r, k);
		}
	}

	public static Comparable solve(Comparable[] arr, int k){
		if(arr == null || k < 0 || k > arr.length){
			throw new IllegalArgumentException("invalid argument");
		}
		return solve(arr, 0, arr.length-1, k - 1);
	}





	private static void swap(Object[] arr, int i, int j){
		Object temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public static void main(String[] args){
		Integer[] a = {134,213,2,4,6234,3,12,3};
		System.out.println(solve(a, 5));
	}
}
