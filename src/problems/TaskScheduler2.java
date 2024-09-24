package problems;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler2 {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> lastExecutionDay = new HashMap<>();
        long currentDay = 0;

        for (int task : tasks) {
            currentDay++;

            if (lastExecutionDay.containsKey(task)) {
                long lastDay = lastExecutionDay.get(task);
                long nextAvailableDay = lastDay + space + 1;

                if (currentDay < nextAvailableDay) {
                    currentDay = nextAvailableDay;
                }
            }

            lastExecutionDay.put(task, currentDay);
        }
        return currentDay;
    }
}
