package problems;

public class MaximumOfAbsoluteValueExpression {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int x1 = Integer.MIN_VALUE;
        int x2 = Integer.MIN_VALUE;
        int x3 = Integer.MIN_VALUE;
        int x4 = Integer.MIN_VALUE;

        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MAX_VALUE;
        int y3 = Integer.MAX_VALUE;
        int y4 = Integer.MAX_VALUE;

        for(int i =0; i < arr1.length; i++){
            x1 = Math.max(x1,arr1[i]+arr2[i]+i);
            y1 = Math.min(y1,arr1[i]+arr2[i]+i);

            x2 = Math.max(x2,arr2[i]-arr1[i]+i);
            y2 = Math.min(y2,arr2[i]-arr1[i]+i);

            x3 = Math.max(x3,arr1[i]-arr2[i]+i);
            y3 = Math.min(y3,arr1[i]-arr2[i]+i);

            x4 = Math.max(x4,i-arr1[i]-arr2[i]);
            y4 = Math.min(y4,i-arr1[i]-arr2[i]);

        }

        return Math.max(x1-y1,Math.max(x2-y2,Math.max(x3-y3,x4-y4)));
    }
}
