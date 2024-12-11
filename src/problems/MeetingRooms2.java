package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        for(int[] i : intervals) {
            list.add(new int[]{i[0], +1});
            list.add(new int[]{i[1], -1});
        }

        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int max = 0;
        int temp = 0;

        for(int[] i : list) {
            temp += i[1];
            max = Math.max(max, temp);
        }

        return max;
    }
}
