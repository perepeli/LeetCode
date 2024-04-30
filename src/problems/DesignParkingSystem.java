package problems;

import java.util.HashMap;
import java.util.Map;

public class DesignParkingSystem {
    Map<Integer, int[]> lot;

    public DesignParkingSystem(int big, int medium, int small) {
        lot = new HashMap<>();
        lot.put(1, new int[]{0, big});
        lot.put(2, new int[]{0, medium});
        lot.put(3, new int[]{0, small});
    }

    public boolean addCar(int carType) {
        if(lot.containsKey(carType)) {
            int[] space = lot.get(carType);
            if(space[0] < space[1]) {
                space[0]++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
