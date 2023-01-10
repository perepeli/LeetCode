package problems;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        int lastEnd = -1;

        for(int[] e: intervals) {
            if(lastEnd > e[0]) return false;
            lastEnd = e[1];
        }
        return true;
    }
}
