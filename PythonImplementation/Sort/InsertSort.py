def insertsort(arr):
    
    for i in range(1,len(arr)):
        temp = arr[i]
        j = i - 1
        while((arr[j] > temp) & (j > -1)):
            arr[j+1] = arr[j]
            j-=1
        arr[j+1] = temp

    return arr

