from MergeSort import mergesort
from SelectionSort import selectionsort
from InsertSort import insertsort
import SortTestHelper


arr = SortTestHelper.RandomTestList(10000,0,10000)
print(arr)
arr1 = arr[:]
arr2 = arr[:]
SortTestHelper.TestSort('SelectionSort', selectionsort, arr)
SortTestHelper.TestSort('MergeSort', mergesort, arr1)
SortTestHelper.TestSort('4', insertsort, arr2)