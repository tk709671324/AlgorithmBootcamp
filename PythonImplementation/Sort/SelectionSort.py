import SortTestHelper

def selectionsort(rlist = None):
    #randomlist
    if rlist == None:
        raise ValueError('Please entering a list')
    ##利用索引进行选择排序
    for i in range(0, len(rlist)):
        min = i
        for j in range(i+1, len(rlist)):
            if rlist[min] > rlist[j]:
                min = j

        temp = rlist[i]
        rlist[i] = rlist[min]
        rlist[min] = temp

    return rlist









