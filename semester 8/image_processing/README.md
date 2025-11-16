# Basic Image Processing Exercises (Python)

## Overview

This mini-project contains a set of small Python scripts that implement classic **grayscale image processing** tasks using NumPy, Matplotlib, and OpenCV:

- Building and visualizing a synthetic 4‑bit image
- Rotating an image by 45° using an explicit rotation matrix
- Histogram equalization
- Histogram stretching (contrast stretching)

Each script is self‑contained and can be run independently.

---

## Requirements

- Python 3.x
- NumPy
- Matplotlib
- OpenCV for Python (`opencv-python`)

Install the dependencies with:

```bash
pip install numpy matplotlib opencv-python
```

---

## Scripts

### 1. `4 bit image.py`

Creates a small **5×5 synthetic grayscale image** represented as a NumPy array with values in the range `[0, 15]`, i.e. a **4‑bit image**. The script:

- Builds the image as a hard‑coded matrix
- Displays it using `matplotlib.pyplot.imshow` with a gray colormap
- Fixes the display range to `[0, 15]` and adds a colorbar for visualization

This demonstrates how digital images can be represented and visualized directly from NumPy arrays.

---

### 2. `45 rotate.py`

Implements a **45° rotation** of the same 5×5 synthetic image using a custom rotation matrix:

- Defines the original image as a 5×5 NumPy array
- Constructs a 2×2 rotation matrix for 45° using cosine and sine
- Rotates each pixel around the center of the image (shift → rotate → shift back)
- Uses nearest‑neighbor assignment to fill a new 5×5 output array
- Displays the rotated result with Matplotlib

This script illustrates manual geometric transformation on images using linear algebra.

---

### 3. `histogram eq.py`

Performs **histogram equalization** on a real grayscale image:

- Loads `cameraman.jpg` in grayscale using `cv2.imread`
- Defines a helper `histogram(photo)` function that:
  - Flattens the image and plots its histogram with 256 bins over `[0, 256)`
- Shows the original histogram
- Applies `cv2.equalizeHist` to enhance global contrast
- Shows the equalized histogram
- Displays the equalized image using Matplotlib

This demonstrates how histogram equalization can improve contrast in an image with poor dynamic range.

---

### 4. `histogram stretching.py`

Implements **histogram stretching (contrast stretching)** manually:

- Loads `cameraman.jpg` in grayscale
- Computes the minimum and maximum pixel values in the image
- Applies a linear mapping

  \\( I_{stretched} = (I - I_{min}) \times \frac{255}{I_{max} - I_{min}} \\)

- Casts the result back to `uint8`
- Plots the original and stretched histograms
- Displays the stretched image with Matplotlib

This is a lower‑level alternative to histogram equalization, directly expanding the intensity range.

---

## How to Run

From the project directory, run any script with Python:

```bash
python "4 bit image.py"
python "45 rotate.py"
python "histogram eq.py"
python "histogram stretching.py"
```

Make sure that **`cameraman.jpg`** is in the same folder as the histogram scripts, or update the `path` variable in those files.

---

## Concepts Practiced

- Representing images as NumPy arrays
- Manual implementation of 2D geometric transformations
- Basic image visualization with Matplotlib
- Global contrast enhancement techniques:
  - Histogram equalization
  - Histogram stretching / contrast stretching
