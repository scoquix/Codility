import java.util.ArrayList;
import java.util.List;

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
    public int solution2(int[] A) {
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


    //-------------------------------------------------------------------------
    // Peaks
    //-------------------------------------------------------------------------
    public int solution(int[] A) {
        boolean[] peaks = create_peaks(A);
        List<Integer> factors = new ArrayList<>();
        create_dividers(A.length, factors);
        int x = 0;
        for (int factor : factors)
            if (check_peak(peaks, factor))
                return A.length / factor;
        return 0;
    }

    private void create_dividers(int numFac, List<Integer> factors) {
        for (int i = 1; i <= numFac; i++)
            if (numFac % i == 0 && i > 2)
                factors.add(i);
    }

    private boolean check_peak(boolean[] A, int plusI) {
        for (int i = 0; i < A.length; i += plusI) {
            int counter = 0;
            for (int j = i; j < i + plusI; j++) {
                if (A[j])
                    counter += 1;
            }
            if (counter == 0)
                return false;
        }
        return true;
    }
}
