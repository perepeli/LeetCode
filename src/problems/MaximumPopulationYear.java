package problems;

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] arr = new int[101];

        for(int[] i : logs) {
            int start = i[0];
            int end = i[1];

            arr[start - 1950]++;
            arr[end - 1950]--;
        }

        int maxPopulation = 0;
        int maxIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            if(i > 0) arr[i] += arr[i - 1];

            if(arr[i] > maxPopulation) {
                maxPopulation = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1950;
    }
}
