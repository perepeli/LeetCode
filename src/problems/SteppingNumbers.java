package problems;

import java.util.*;

public class SteppingNumbers {
    public List<Integer> countSteppingNumbers(int low, int high) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(low==0) result.add(0);
        for(int i=1;i<=9;i++)
            queue.add(i);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr>=low&&curr<=high)
                result.add(curr);
            if(curr>high/10) continue;
            int lastDigit = curr%10;

            if(lastDigit!=9&&curr*10+lastDigit+1<=high)
                queue.offer(curr*10+lastDigit+1);

            if(lastDigit!=0&&curr*10+lastDigit-1<=high)
                queue.offer(curr*10+lastDigit-1);
        }

        Collections.sort(result);
        return result;
    }
}
