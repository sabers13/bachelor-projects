s = str(input())

arrLen = 2 * len(s) + 3
modS = [0]*arrLen

modS[0] = '!'
modS[arrLen - 1] = '@'
j = 1
for i in s:
    modS[j] = '#'
    j += 1
    modS[j] = i
    j += 1
modS[j] = '#'

palLen = L = R = C = 0
mirrorMap = [0] * arrLen
for i in range(1, arrLen - 1):
    if i < R:
        if mirrorMap[2 * C - i] < R - i:
            mirrorMap[i] = mirrorMap[2 * C - i]
        else:
            mirrorMap[i] = R - i

    while modS[i + mirrorMap[i] + 1] == modS[i - mirrorMap[i] - 1]:
        mirrorMap[i] += 1

    if i + mirrorMap[i] > R:
        R = i + mirrorMap[i]
        C = i

    if mirrorMap[i] > palLen:
        palLen = mirrorMap[i]

print(palLen)



