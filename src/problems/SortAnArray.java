package problems;

import java.util.Arrays;
import java.util.Random;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        //mergeSort(nums); // merge sort
        quickSort(nums, 0, nums.length - 1); // quick sort
        return nums;
    }

    private void quickSort(int[] numbers, int left, int right) { // quick sort
        if(left >= right) return;

        int pivot = partition(numbers, left, right);
        quickSort(numbers, left, pivot - 1);
        quickSort(numbers, pivot + 1, right);
    }


    private int partition(int[] numbers, int left, int right){
        int middleIndex = (right + left) / 2;

        swap(numbers, middleIndex, right);
        int pivot = right;

        int lessIndex = left-1;
        for(int i = left; i<= right; i++){
            if(numbers[i] < numbers[pivot]){
                lessIndex++;
                swap(numbers, lessIndex, i);
            }
        }
        lessIndex++;
        swap(numbers, lessIndex, pivot);
        return lessIndex;
    }

    private void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }


    private void mergeSort(int[] numbers) { // merge sort
        int arrLength = numbers.length;

        if(arrLength < 2) return;

        int midIndex = arrLength / 2;
        int[] leftArr = new int[midIndex];
        int[] rightArr = new int[arrLength - midIndex];

        for(int i = 0; i < midIndex; i++) leftArr[i] = numbers[i];
        for(int i = midIndex; i < arrLength; i++) rightArr[i - midIndex] = numbers[i];

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(numbers, leftArr, rightArr);
    }

    private void merge(int[] targetArr, int[] leftArr, int[] rightArr) {
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;

        int left = 0;
        int right = 0;

        int index = 0;

        while(left < leftLen && right < rightLen) {
            if(leftArr[left] < rightArr[right]) {
                targetArr[index] = leftArr[left];
                left++;
            } else {
                targetArr[index] = rightArr[right];
                right++;
            }
            index++;
        }

        while(left < leftLen) {
            targetArr[index] = leftArr[left];
            left++;
            index++;
        }

        while(right < rightLen) {
            targetArr[index] = rightArr[right];
            right++;
            index++;
        }
    }
}
