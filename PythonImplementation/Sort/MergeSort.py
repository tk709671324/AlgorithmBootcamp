import SortTestHelper


def __merge(arr , l, mid, r):

    #归并操作，arr为原数组, lr 为带排序的部分索引值
    #k为在原数组上的待排序位置
    #ij用于标记在辅助数组中左右两部分相比较的索引值

    assist = arr[l:r+1]
    k = l
    i = l
    j = mid+1

    for k in range(l, r+1):
        #先检查索引范围，当排序未结束时，及k未在lr之间遍历完时
        #如果i j超过了各自的部分，则将另一部分的剩余部分一次填入原数组
        if(i > mid):
            arr[k] = assist[j-l]
            j+=1
        elif(j > r):
            arr[k] = assist[i-l]
            i+=1
        else:
            if(assist[i-l] <= assist[j-l]):
                arr[k] = assist[i-l]
                i+=1
            else:
                arr[k] = assist[j-l]
                j+=1





def __mergesort(arr, l, r):

    #递归调用，将两部分排序好之后再归并成一组


    if(l >= r):
        return

    mid = int((l+r)/2)
    __mergesort(arr, l, mid)
    __mergesort(arr, mid+1, r)
    __merge(arr, l, mid, r)

def mergesort(arr):
    __mergesort(arr, 0, int(len(arr))-1 )
    return arr




