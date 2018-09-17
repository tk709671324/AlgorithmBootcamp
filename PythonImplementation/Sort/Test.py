from MergeSort import mergesort
from SelectionSort import selectionsort
from InsertSort import insertsort
import SortTestHelper

n = 100000
arr = SortTestHelper.RandomTestList(n,0,n)
print(arr)
arr1 = arr[:]
arr2 = arr[:]
SortTestHelper.TestSort('SelectionSort', selectionsort, arr)
SortTestHelper.TestSort('MergeSort', mergesort, arr1)
SortTestHelper.TestSort('InsertionSort', insertsort, arr2)