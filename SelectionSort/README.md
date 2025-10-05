# Selection Sort Implementation

## Overview
Optimized Selection Sort algorithm implementation with early termination and comprehensive performance metrics tracking.

## Features
- Early termination for already sorted portions
- Comprehensive performance metrics (time, comparisons, swaps, array accesses)
- Support for various input patterns (random, sorted, reverse, nearly-sorted)
- Extensive unit test coverage
- CSV export for performance data

## Complexity Analysis
- **Time Complexity**: O(n²) in worst and average cases, Ω(n) in best case (with early termination)
- **Space Complexity**: O(1) - in-place sorting
- **Stability**: Not stable

## Building and Running

### Compile and Test
```bash
mvn compile
mvn test