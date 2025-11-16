import cv2
import matplotlib.pyplot as plt

path = 'cameraman.jpg'
image = cv2.imread(path, cv2.IMREAD_GRAYSCALE)


def histogram(photo):
    plt.hist(photo.ravel(), bins=256, range=(0, 256))
    plt.show()


histogram(image)
equalized_image = cv2.equalizeHist(image)
histogram(equalized_image)
plt.imshow(equalized_image, cmap='gray')
plt.show()
