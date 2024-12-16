import numpy as np


def chopped(arr2d, n):
    for i in range(1, n):
        arr2d[i][0] += arr2d[i - 1][0]

    for j in range(1, n):
        arr2d[0][j] += arr2d[0][j - 1]

    for i in range(1, n):
        for j in range(1, n):
            arr2d[i][j] += (min(arr2d[i - 1][j - 1], min(arr2d[i - 1][j], arr2d[i][j - 1])))
    return arr2d[n - 1][n - 1]


n = int(input())
test = input()
string_list = test.split(" ")
array = []
for num in string_list:
    try:
        array.append(int(num))
    except:
        pass
arr2d = np.reshape(array, (n+1, n+1))
print(chopped(arr2d, n+1))

