def fibo(n):
    if(n==0):
        return 0
    elif(n==1):
        return 1
    else:
        A = [1,1]
        for i in range(2,n+1):
            a=A[i-1]+A[i-2]
            A.append(a)
        #print(A)
        return (A[len(A)-1])
n = int(input())
print(fibo(n))