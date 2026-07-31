package problems;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MinimizeRoundingErrorToMeetTarget {
    public String minimizeError(String[] prices, int target) {
        double result = minRoundingErrorRec( prices, target, 0 , new HashMap<>(), 0);
        if( result == Double.MAX_VALUE)
            return "-1";
        DecimalFormat newFormat = new DecimalFormat("#.###");
        result = Double.valueOf(newFormat.format(result));

        StringBuilder sb = new StringBuilder(Double.toString(result));
        int dotIndex = sb.indexOf(".");
        while (sb.length() - dotIndex <= 3) {
            sb.append('0');
        }
        return sb.toString();
    }

    public double minRoundingErrorRec(String[] prices, int target, int idx, Map<String, Double> memo, double remaining){

        if( idx == prices.length ){
            if( remaining == target ){
                return 0.0;
            }
            return Double.MAX_VALUE;
        }
        if( memo.containsKey(idx+"-"+remaining))
            return  memo.get(idx+"-"+remaining);
        double current = Double.parseDouble(prices[idx]);
        double roundUp = minRoundingErrorRec( prices, target , idx+1 , memo , remaining + Math.ceil(current));

        if( roundUp != Double.MAX_VALUE){
            roundUp+=(double)Math.ceil(current) - current;
        }
        double roundDown = minRoundingErrorRec( prices, target , idx+1 , memo , remaining + Math.floor(current));

        if( roundDown != Double.MAX_VALUE){
            double roundDownValue = current - (int)current;
            roundDown+= roundDownValue;
        }
        memo.put( idx+"-"+ remaining , Math.min(roundUp, roundDown));

        return Math.min(roundUp, roundDown);
    }

}
