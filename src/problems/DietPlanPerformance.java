package problems;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int N = calories.length;
        int points = 0;

        int left = 0;
        int right = 0;
        int sum = 0;

        while(right < k) {
            sum += calories[right++];
        }

        if(sum < lower) points--;
        if(sum > upper) points++;

        while(right < N) {
            sum -= calories[left++];
            sum += calories[right++];

            if(sum < lower) points--;
            if(sum > upper) points++;
        }


        return points;
    }
}
