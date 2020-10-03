public class Lesson10 {
    //-------------------------------------------------------------------------
    // Count Factors
    //-------------------------------------------------------------------------
    public int solution(int N) {
        int result = 0;
        long i = 1;
        while (i * i < (long) N) {
            if (N % i == 0)
                result += 2;
            i++;
        }
        if (i * i == (long) N)
            result += 1;
        return result;
    }

    //-------------------------------------------------------------------------
    // Flags
    //-------------------------------------------------------------------------
    public int solution(int[] A) {
        boolean[] peaks = create_peaks(A);
        int[] nextPeaks = next_peak(peaks);
        int maxFlagNum = 0;
        for (int flagNum = 1; (flagNum - 1) * flagNum < A.length; flagNum++)
            if (canSetFlags(nextPeaks, flagNum))
                maxFlagNum = Math.max(maxFlagNum, flagNum);
        return maxFlagNum;
    }

    private int[] next_peak(boolean[] peaks) {
        int[] next = new int[peaks.length];
        int nextPeak = -1;
        for (int i = next.length - 1; i >= 0; i--) {
            if (peaks[i])
                nextPeak = i;
            next[i] = nextPeak;
        }
        return next;
    }

    private boolean canSetFlags(int[] nextPeaks, int flagNum) {
        int index = 0;
        for (int i = 0; i < flagNum; i++) {
            if (index >= nextPeaks.length || nextPeaks[index] < 0)
                return false;
            index = nextPeaks[index] + flagNum;
        }
        return true;
    }

    private boolean[] create_peaks(int[] A) {
        boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks[i] = true;
            }
        }
        return peaks;
    }
}
