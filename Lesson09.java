public class Lesson09 {
    //-------------------------------------------------------------------------
    // MaxSliceSum
    //-------------------------------------------------------------------------

    public int solution(int[] A) {
        int absoluteMax = A[0];
        int localMax = A[0];
        int nextSum;
        int currentElement;

        for (int i = 1; i < A.length; i++) {
            currentElement = A[i];
            nextSum = currentElement + localMax;
            localMax = Math.max(A[i], nextSum);
            absoluteMax = Math.max(absoluteMax, localMax);
        }
        return absoluteMax;
    }

    //-------------------------------------------------------------------------
    // MaxProfit
    //-------------------------------------------------------------------------

    public int solution2(int[] A) {
        if (A.length < 2)
            return 0;
        else {
            int max_profit = 0;
            int local_diff;
            int local_min = A[0];
            for (int i = 1; i < A.length; i++) {
                local_min = Math.min(A[i], local_min);
                local_diff = A[i] - local_min;
                max_profit = Math.max(local_diff, max_profit);
            }
            return max_profit;
        }
    }

    //-------------------------------------------------------------------------
    //    MaxDoubleSliceSum
    //-------------------------------------------------------------------------
    private int solution3(int[] A) {
        if (A.length < 4)
            return 0;
        else {
            int N = A.length;
            int[] K1 = new int[N];
            int[] K2 = new int[N];
            for (int i = 1; i < N - 1; i++) {
                K1[i] = Math.max(K1[i - 1] + A[i], 0);
            }
            for (int i = N - 2; i > 0; i--) {
                K2[i] = Math.max(K2[i + 1] + A[i], 0);
            }
            int max = 0;
            for (int i = 1; i < N - 1; i++) {
                max = Math.max(K1[i - 1] + K2[i + 1], max);
            }
            return max;
        }
    }
}
