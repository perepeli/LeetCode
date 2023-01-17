package problems;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {

        int secondHalf = nums.length/2+1;

        int[] arr1 = new int[nums.length/2];
        int[] arr2 = new int[nums.length/2];

        int[] arrayToReturn = new int[nums.length];

        int counter = 0;

        for(int i = 0; i < nums.length/2; i++) {
            arr1[i] = nums[i];
        }

        counter = 0;

        for(int i = nums.length/2; i < nums.length; i++) {
            arr2[counter] = nums[i];
            counter++;
        }

        counter = 0;

        for(int i = 0; i < nums.length-1; i+= 2) {
            arrayToReturn[i] = arr1[counter];
            arrayToReturn[i+1] = arr2[counter];
            counter++;
        }

        return arrayToReturn;

    }
}
