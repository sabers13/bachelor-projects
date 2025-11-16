import numpy as num
import matplotlib.pyplot as plot

field_of_image = num.array([
    [7, 3, 6, 0, 2],
    [5, 8, 1, 6, 5],
    [0, 7, 3, 4, 0],
    [5, 11, 9, 0, 8],
    [0, 3, 8, 5, 7]
], dtype=num.uint8)

rotated_array = num.array([
    [num.cos(num.radians(45)), -num.sin(num.radians(45))],
    [num.sin(num.radians(45)), num.cos(num.radians(45))]
])

rotated_image = num.zeros(field_of_image.shape, dtype=num.uint8)

for x in range(field_of_image.shape[0]):
    for y in range(field_of_image.shape[1]):
        shifted_x = x - 2.5
        shifted_y = y - 2.5
        rotated_x = num.round(shifted_x * rotated_array[0, 0] + shifted_y * rotated_array[0, 1] + 2.5).astype(int)
        rotated_y = num.round(shifted_x * rotated_array[1, 0] + shifted_y * rotated_array[1, 1] + 2.5).astype(int)
        if 0 <= rotated_x < field_of_image.shape[0] and 0 <= rotated_y < field_of_image.shape[1]:
            rotated_image[x, y] = field_of_image[rotated_x, rotated_y]

plot.imshow(rotated_image, cmap='gray', vmin=0, vmax=15)
plot.colorbar()
plot.show()
