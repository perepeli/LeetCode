package problems;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int newLength = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) newLength++;
            newLength++;
        }

        int index = arr.length - 1;
        int newIndex = newLength - 1;

        while(index >= 0) {
            if(arr[index] == 0) {
                if(newIndex < arr.length) {
                    arr[newIndex] = arr[index];
                }
                newIndex--;
                if(newIndex < arr.length) {
                    arr[newIndex] = arr[index];
                }
                index--;
                newIndex--;
            } else {
                if(newIndex < arr.length) {
                    arr[newIndex] = arr[index];
                }
                index--;
                newIndex--;
            }
        }
    }
}
