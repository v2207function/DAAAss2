# Assignment 2 – Insertion Sort Performance Analysis

**Author:** Kaisar Matygul

## Overview
This assignment analyzes the performance of the Insertion Sort algorithm on various datasets.

## Results Summary

| Type      | Size | Comparisons | Moves | Time (ms) |
|------------|------|--------------|--------|-----------|
| Random     | 100  | 2640         | 2642   | 0.116     |
| Random     | 1000 | 245988       | 245993 | 2.621     |
| Random     | 5000 | 6268661      | 6268670 | 6.024     |
| Random     | 10000| 24847775     | 24847788 | 29.114    |
| Sorted     | 100  | 99           | 99     | 0.001     |
| Sorted     | 1000 | 999          | 999    | 0.002     |
| Sorted     | 5000 | 4999         | 4999   | 0.010     |
| Sorted     | 10000| 9999         | 9999   | 0.020     |
| Reversed   | 100  | 4950         | 5049   | 0.006     |
| Reversed   | 1000 | 499500       | 500499 | 0.472     |
| Reversed   | 5000 | 12497500     | 12502499 | 9.226    |
| Reversed   | 10000| 49995000     | 50004999 | 33.033   |

## Conclusion
Insertion Sort is efficient only for small or nearly sorted datasets. For large or reversed data,
its O(n²) behavior makes it unsuitable for high-performance applications.
