package problems;

public class DigitCountInRange {
    public int digitsCount(int d, int low, int high) {
        return helper(high,d) - helper(low-1,d);
    }

    int helper(int v, int d) {
        int count=0;
        for(int i=1;i<=v;i*=10) {
            if(d!=0) count+=v/(i*10)*i + Math.min(Math.max(v%(i*10)-d*i+1,0),i);
            else count+=Math.max(v/(i*10)-1,0)*i + (v/(i*10)==0?0:Math.min(Math.max(v%(i*10)+1,0),i));
        }

        if(d==0) count++;
        return count;
    }
}
