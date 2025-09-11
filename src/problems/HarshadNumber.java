package problems;

public class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum=0,dup=x;

        while(x!=0) {
            sum=sum+(x%10);
            x/=10;
        }

        return dup%sum == 0 ? sum : -1;
    }
}
