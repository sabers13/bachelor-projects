import numpy as num
import matplotlib.pyplot as plot

filed_of_image = field_of_image = num.array([
    [7, 3, 6, 0, 2],
    [5, 8, 1, 6, 5],
    [0, 7, 3, 4, 0],
    [5, 11, 9, 0, 8],
    [0, 3, 8, 5, 7]
], dtype=num.uint8)

plot.imshow(filed_of_image, cmap='gray', vmin=0, vmax=15)
plot.colorbar()
plot.show()
