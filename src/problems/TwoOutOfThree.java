package problems;

import java.util.*;

public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> map = new HashMap<>();

        Set<Integer> redundant1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                redundant1.add(nums1[i]);
                map.put(nums1[i], 1);
            } else {
                if(!redundant1.contains(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                }
            }
        }

        //System.out.println(map);

        Set<Integer> redundant2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                redundant2.add(nums2[i]);
                map.put(nums2[i], 1);
            } else {
                if(!redundant2.contains(nums2[i])) {
                    map.put(nums2[i], map.get(nums2[i]) + 1);
                }
            }
        }

        //System.out.println(map);

        Set<Integer> redundant3 = new HashSet<>();
        for (int i = 0; i < nums3.length; i++) {
            if (!map.containsKey(nums3[i])) {
                redundant3.add(nums3[i]);
                map.put(nums3[i], 1);
            } else {
                if(!redundant3.contains(nums3[i])) {
                    map.put(nums3[i], map.get(nums3[i]) + 1);
                }
            }
        }

        //System.out.println(map);

        List<Integer> list = new ArrayList<>();

        for (Integer key : map.keySet()) {
            if (map.get(key) >= 2) {
                list.add(key);
            }
        }
        return list;
    }
}
