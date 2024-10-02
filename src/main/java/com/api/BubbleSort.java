package com.api;

import ch.qos.logback.classic.spi.LoggerContextVO;

import java.util.Arrays;
import java.util.Scanner;

    public class BubbleSort {
        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            boolean swapped;

            // Outer loop for each pass through the array
            for (int i = 0; i < n - 1; i++) {
                swapped = false;

                // Inner loop for comparing adjacent elements
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Swap elements if they are in the wrong order
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;

                        swapped = true; // Mark that a swap has occurred
                    }
                }

                // If no elements were swapped in this pass, the array is already sorted
                if (!swapped) {
                    break;
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};

            System.out.println("Original array: " + Arrays.toString(arr));

            bubbleSort(arr);

            System.out.println("Sorted array: " + Arrays.toString(arr));
        }
    }

