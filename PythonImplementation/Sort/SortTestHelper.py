import random
from time import  time

def RandomTestList(n = 10, randoml = 0, randomr = 10):

    ##生成一个随机list用于算法性能测试，n为list元素个数，randoml randomr为素组的上下界

    if randomr - randoml <= 0 :
        raise ValueError('invalid interval')

    r = []
    for _ in range(0,n):
        r.append(random.randint(randoml, randomr))

    return r

def NearlyOrderedList(n = 100, Swaptimes = 10):

    #生成一个近乎有序的list，Swaptimes越小越有序

    result = []
    for i in range(0, n):
        result.append(i)

    for i in range(0, Swaptimes):
        a = random.randint(0, n)
        b = random.randint(0, n)
        result[a], result[b] = result[b], result[a]

    return result



def TestSort(name, sortfuc, arr):

    #测试传入排序的性能，name为待测试算法的名字，sortfuc是待测试算法的函数实现，arr是用于测试的数据

    start = time()
    result = sortfuc(arr)
    end = time()

    print('SortedArray:{}\nSortName:{}\nArrayLenth:{}\nTime:{:.5f}'.format(result, name, len(arr), end - start))









