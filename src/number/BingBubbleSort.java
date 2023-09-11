/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package number;

/**
 * "Írj egy java programot ami sorbarendez 20 számot"
 * @author laszlo.nagy & MS Bing Chat
 * 
 * Ügyes...
 */
// Java program to sort 20 numbers in ascending order using bubble sort method
public class BingBubbleSort {

    // A method to sort an array of integers using bubble sort algorithm
    public static void bubbleSort(int[] array) {
        // Get the length of the array
        int n = array.length;

        // Loop through the array n-1 times
        for (int i = 0; i < n - 1; i++) {
            // Loop through the array from 0 to n-i-1
            for (int j = 0; j < n - i - 1; j++) {
                // Compare the current element with the next element
                if (array[j] > array[j + 1]) {
                    // Swap the elements if they are in wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // A method to print an array of integers
    public static void printArray(int[] array) {
        // Loop through the array and print each element
        for (int element : array) {
            System.out.print(element + " ");
        }
        // Print a new line
        System.out.println();
    }

    // The main method to test the program
    public static void main(String[] args) {
        // Create an array of 20 random numbers between 1 and 100
        int[] array = {34, 76, 12, 89, 45, 23, 67, 98, 54, 10,
                       81, 39, 27, 64, 18, 92, 41, 73, 36, 50};

        // Print the original array
        System.out.println("Original array:");
        printArray(array);

        // Sort the array using bubble sort method
        bubbleSort(array);

        // Print the sorted array
        System.out.println("Sorted array:");
        printArray(array);
    }
}

