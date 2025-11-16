import cv2
import numpy as np
import matplotlib.pyplot as plt

path = 'cameraman.jpg'
image = cv2.imread(path, cv2.IMREAD_GRAYSCALE)


def histogram(photo):
    plt.hist(photo.ravel(), bins=256, range=(0, 256))
    plt.show()


min = np.min(image)
max = np.max(image)
stretched_image = (image - min) * (255 / (max - min))
stretched_image = stretched_image.astype(np.uint8)
histogram(image)
histogram(stretched_image)
plt.imshow(stretched_image, cmap='gray')
plt.show()
