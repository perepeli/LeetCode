package problems;

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        int sum = 0;
        int size = String.valueOf(n).length();
        boolean b = true;
        if(size % 2 == 0) b = false;

        while(n != 0){
            int temp = n % 10;
            n /= 10;

            if(!b) sum-=temp;
            else sum+=temp;

            b=!b;
        }

        return sum;
    }
}
