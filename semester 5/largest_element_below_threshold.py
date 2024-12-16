def QuickSort(arr, m):
    elements = len(arr)

    if elements < 1:
        return arr

    current_position = 0

    for i in range(1, elements):

        if arr[i] <= arr[0]:
            current_position += 1
            (arr[i], arr[current_position]) = (arr[current_position], arr[i])
    (arr[0], arr[current_position]) = (arr[current_position], arr[0])
    left = QuickSort(arr[0:current_position], m)
    right = QuickSort(arr[current_position + 1:elements], m)

    if arr[current_position] < m:
        arr = left + [arr[current_position]] + right

    else:
        arr = left
    return arr

input_string = input()
string_list = input_string.split(" ")
A = []
for num in string_list:
    try:
        A.append(int(num))
    except:
        pass
m = int(input())
A = QuickSort(A, m)
if len(A) > 1:
    print(A[len(A)-1])
else:
    print(-1)
