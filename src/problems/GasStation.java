package problems;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int gasSum = 0;
        int costSum = 0;

        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            diff[i] = gas[i] - cost[i];
        }

        if(gasSum < costSum) return -1;

        int index = 0;
        int tempIndex = 0;
        int tempGas = 0;

        while(tempIndex < gas.length) {
            tempGas += diff[tempIndex];
            if(tempGas >= 0) {
                tempIndex++;
            } else {
                tempGas = 0;
                tempIndex++;
                index = tempIndex;
            }
        }

        return index;
    }
}
