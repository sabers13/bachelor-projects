
def mergeSort(array, pairs):
    if len(array) > 1:
        mid = len(array)//2
        left = array[:mid]
        right = array[mid:]
        pairs = pairs + mergeSort(left, pairs)
        pairs = pairs + mergeSort(right, pairs)

        i = j = k = z = w = 0
        for w in range(len(left)):
            for z in range(len(right)):
                if left[w] > 2*right[z]:
                    pairs = pairs+1

        while i < len(left) and j < len(right):
            if left[i] < right[j]:
                array[k] = left[i]
                i += 1
            else:
                array[k] = right[j]
                j += 1
            k += 1

        while i < len(left):
            array[k] = left[i]
            i += 1
            k += 1

        while j < len(right):
            array[k] = right[j]
            j += 1
            k += 1
    return pairs

pairs = 0

input_string = input()
input_string = input_string[1:len(input_string)-1]
string_list = input_string.split(",")
array = []
for num in string_list:
    try:
        array.append(int(num))
    except:
        pass

#array = [1, 3, 2, 3, 1]
pairs = 0
res = mergeSort(array, pairs)
print(res)