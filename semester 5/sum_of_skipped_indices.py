
def partition(array, low, high):

	pivot = array[high]
	i = low - 1
	for j in range(low, high):
		if array[j] <= pivot:
			i = i + 1
			(array[i], array[j]) = (array[j], array[i])

	(array[i + 1], array[high]) = (array[high], array[i + 1])
	return i + 1

# function to perform quicksort


def quickSort(array, low, high):
	if low < high:
		pi = partition(array, low, high)

		quickSort(array, low, pi - 1)

		quickSort(array, pi + 1, high)
		return len(temp)-(pi+1)


input_string = input()
string_list = input_string.split(" ")
A = []
for num in string_list:
    try:
        A.append(int(num))
    except:
        pass

temp = []
num = 0
sum = 0
for i in range(len(A)):
	temp.append(A[i])
	size = len(temp)
	num = quickSort(temp, 0, size - 1)
	if(num != None):
		sum=sum+num


print(sum)
