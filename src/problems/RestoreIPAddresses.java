package problems;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new int[]{0,0,0,0}, 0, res);
        return res;
    }

    private void backtrack(String s, int index, int[] ip, int ipIndex, List<String> res) {
        if(ipIndex == 4 && index == s.length()) {
            res.add(ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
            return;
        }

        if(index == s.length() || ipIndex == 4) return;

        int curr = s.charAt(index) - '0';

        int[] newIp = new int[]{ip[0], ip[1], ip[2], ip[3]};

        if(curr == 0) {
            if(newIp[ipIndex] == 0) {
                backtrack(s, index + 1, newIp, ipIndex + 1, res);
            } else {
                newIp[ipIndex] *= 10;
                if(newIp[ipIndex] < 255) {
                    backtrack(s, index + 1, newIp, ipIndex, res);
                    backtrack(s, index + 1, newIp, ipIndex + 1, res);
                } else if(newIp[ipIndex] == 255) {
                    backtrack(s, index + 1, newIp, ipIndex + 1, res);
                }
            }
        } else {
            if(newIp[ipIndex] == 0) {
                newIp[ipIndex] += curr;

                backtrack(s, index + 1, newIp, ipIndex, res);
                backtrack(s, index + 1, newIp, ipIndex + 1, res);
            } else {
                newIp[ipIndex] *= 10;
                newIp[ipIndex] += curr;

                if(newIp[ipIndex] < 255) {
                    backtrack(s, index + 1, newIp, ipIndex, res);
                    backtrack(s, index + 1, newIp, ipIndex + 1, res);
                } else if(newIp[ipIndex] == 255) {
                    backtrack(s, index + 1, newIp, ipIndex + 1, res);
                }
            }
        }
    }
}
